package com.qu.flowcore.service.Impl;

import com.qu.flowcore.entity.dto.FlowProcDefDto;
import com.qu.flowcore.entity.vo.ModelInfoVo;
import com.qu.flowcore.enums.FlowableExceptionCode;
import com.qu.flowcore.service.FlowDefinitionService;
import com.qu.flowcore.service.FlowService;
import org.apache.commons.lang3.StringUtils;
import org.flowable.bpmn.converter.BpmnXMLConverter;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.editor.language.json.converter.BaseBpmnJsonConverter;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.repository.ProcessDefinitionQuery;
import org.flowable.ui.common.util.XmlUtil;
import org.flowable.validation.ProcessValidator;
import org.flowable.validation.ProcessValidatorFactory;
import org.flowable.validation.ValidationError;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 流程定义
 *
 * @author qu
 * @date 2021-11-25
 */
@Service
public class FlowDefinitionServiceImpl extends FlowService implements FlowDefinitionService {

    private static final String BPMN_FILE_SUFFIX = ".bpmn";
//    @Autowired
//    private BpmnXMLConverter bpmnXMLConverter;
//    @Autowired
//    private ProcessValidatorFactory processValidatorFactory;

    @Override
    public Boolean exist(String processDefinitionKey) {
        ProcessDefinitionQuery processDefinitionQuery
                = repositoryService.createProcessDefinitionQuery().processDefinitionKey(processDefinitionKey);
        long count = processDefinitionQuery.count();
        return count > 0;
    }

    /**
     * 一期有且仅有一个流程图，所以只能查询到一个ID，并且为了降低耦合，返回String类型的ID，而不是整个对象
     * 二期产品给改成多租户多流程了……要重写
     * @return flowProcDefDto
     * 注意返回值中的name、key，对应的是bpmn文件中的name。在部署时输入的resourceName自动增加bpmn后缀
     */
    @Override
    public Boolean getProcessDefinition(ModelInfoVo modelInfoVo) {
        try {
            //组合查询条件，租户ID为必填，流程图名字和分类使用精确查询
            ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery().orderByProcessDefinitionVersion().desc();
            if(StringUtils.isNotEmpty(modelInfoVo.getResourceName())){
                processDefinitionQuery.processDefinitionResourceName(modelInfoVo.getResourceName()+".bpmn");
            }
            if(StringUtils.isNotEmpty(modelInfoVo.getCategory())){
                processDefinitionQuery.processDefinitionCategory(modelInfoVo.getCategory());
            }
            if(null == modelInfoVo.getTenantId()){
                return BaseResponse.fail(FlowableExceptionCode.GET_PROCESS_DEFINITION.getCode(),FlowableExceptionCode.GET_PROCESS_DEFINITION.getMsg());
            }else{
                processDefinitionQuery.processDefinitionTenantId(String.valueOf(modelInfoVo.getTenantId()));
            }
            //查询列表，不再使用single结果，为了兼容需求多种情况
            List<ProcessDefinition> processDefinitionList = processDefinitionQuery.list();
            List<FlowProcDefDto> resultList = new ArrayList<>();
            if(!processDefinitionList.isEmpty()){
                processDefinitionList.forEach(processDefinition -> {
                    FlowProcDefDto flowProcDefDto = new FlowProcDefDto();
                    BeanUtils.copyProperties(processDefinition, flowProcDefDto);
                    resultList.add(flowProcDefDto);
                });
            }
            //todo 没写返回值
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Boolean.FALSE;
    }

    /**
     * 当bpmn文件内的name相同，变量version将自增。
     * 当查询接口查询到多个流程图，将按照版本号倒序展示
     * @see FlowDefinitionServiceImpl#getProcessDefinition(ModelInfoVo)
     * @param modelInfoVo
     * @return
     */
    @Override
    public Boolean importBpmnModel(ModelInfoVo modelInfoVo){
        InputStream in = null;
        try{
            //转换为XML对象
            in = modelInfoVo.getFile().getInputStream();
            String fileName = modelInfoVo.getFile().getOriginalFilename();
            if(!fileName.endsWith(".bpmn20.xml")){
                //throw new RuntimeException();
                return BaseResponse.fail("请上传后缀为.bpmn20.xml的文件");
            }
            XMLInputFactory xif = XmlUtil.createSafeXmlInputFactory();
            InputStreamReader xmlIn = new InputStreamReader(in, StandardCharsets.UTF_8);
            XMLStreamReader xtr = xif.createXMLStreamReader(xmlIn);
            //将XML转换成model
            BpmnModel bpmnModel = new BpmnXMLConverter().convertToBpmnModel(xtr);
            bpmnModel.setTargetNamespace(BaseBpmnJsonConverter.NAMESPACE);
            if (CollectionUtils.isEmpty(bpmnModel.getProcesses())) {
                throw new RuntimeException(FlowableExceptionCode.BPMN_PROCESSES_EXCEPTION.getCode(),FlowableExceptionCode.BPMN_PROCESSES_EXCEPTION.getMsg());
                //return BaseResponse.fail(FlowableExceptionCode.BPMN_PROCESSES_EXCEPTION.getCode(),FlowableExceptionCode.BPMN_PROCESSES_EXCEPTION.getMsg());
            }
            if (bpmnModel.getLocationMap().size() == 0) {
                throw new RuntimeException(FlowableExceptionCode.BPMN_LOCATIONMAP_EXCEPTION.getCode(),FlowableExceptionCode.BPMN_LOCATIONMAP_EXCEPTION.getMsg());
                 //return BaseResponse.fail(FlowableExceptionCode.BPMN_LOCATIONMAP_EXCEPTION.getCode(),FlowableExceptionCode.BPMN_LOCATIONMAP_EXCEPTION.getMsg());
            }
            //模板验证
            ProcessValidator processValidator = new ProcessValidatorFactory().createDefaultProcessValidator();
            List<ValidationError> validationErrors = processValidator.validate(bpmnModel);
            if (CollectionUtils.isNotEmpty(validationErrors)) {
                StringBuffer message = new StringBuffer();
                validationErrors.forEach(validationError -> message.append(validationError.getDefaultDescription()));
                throw new RuntimeException(FlowableExceptionCode.BPMN_FILE_READ_EXCEPTION.getCode(),String.format(FlowableExceptionCode.BPMN_FILE_READ_EXCEPTION.getMsg(),message));
                //return BaseResponse.fail(FlowableExceptionCode.BPMN_FILE_READ_EXCEPTION.getCode(),String.format(FlowableExceptionCode.BPMN_FILE_READ_EXCEPTION.getMsg(),message));
            }

            //导入，未使用flowable命令，直接使用接口
            Deployment deploy = repositoryService.createDeployment().addBpmnModel(modelInfoVo.getResourceName() + BPMN_FILE_SUFFIX,bpmnModel)
                    //addInputStream(modelInfoVo.getName() + BPMN_FILE_SUFFIX, in)
                    .tenantId(String.valueOf(modelInfoVo.getTenantId())).category(modelInfoVo.getCategory()).deploy();
            ProcessDefinition definition = repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();
            repositoryService.setProcessDefinitionCategory(definition.getId(), modelInfoVo.getCategory());
        }catch (Exception e) {
            //throw new RuntimeException(FlowableExceptionCode.BPMN_FILE_EXCEPTION.getCode(),FlowableExceptionCode.BPMN_FILE_EXCEPTION.getMsg());
            e.printStackTrace();
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public void delete(String deployId) {
        // true 允许级联删除 ,不设置会导致数据库外键关联异常
        repositoryService.deleteDeployment(deployId, true);
    }

    @Override
    public Boolean activateProcessDefinitionInstanceById(String deployId) {
        try {
            ProcessDefinition procDef = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).singleResult();
            repositoryService.activateProcessDefinitionById(procDef.getId(), true, null);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean suspendProcessDefinitionInstanceById(String deployId) {
        try {
            ProcessDefinition procDef = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).singleResult();
            repositoryService.suspendProcessDefinitionById(procDef.getId(), true, null);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
    }


//    /**
//     * 读取xml
//     *
//     * @param deployId
//     * @return
//     */
//    @Override
//    public AjaxResult readXml(String deployId) throws IOException {
//        ProcessDefinition definition = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).singleResult();
//        InputStream inputStream = repositoryService.getResourceAsStream(definition.getDeploymentId(), definition.getResourceName());
//        String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
//        return AjaxResult.success("", result);
//    }
//
//    /**
//     * 读取xml
//     *
//     * @param deployId
//     * @return
//     */
//    @Override
//    public InputStream readImage(String deployId) {
//        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployId).singleResult();
//        //获得图片流
//        DefaultProcessDiagramGenerator diagramGenerator = new DefaultProcessDiagramGenerator();
//        BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinition.getId());
//        //输出为图片
//        return diagramGenerator.generateDiagram(
//                bpmnModel,
//                "png",
//                Collections.emptyList(),
//                Collections.emptyList(),
//                "宋体",
//                "宋体",
//                "宋体",
//                null,
//                1.0,
//                false);
//
//    }
}
