package com.sinoiov.zczhgl.flowable.service;

import com.sinoiov.zczhgl.common.response.BaseResponse;
import com.sinoiov.zczhgl.flowable.entity.vo.ModelInfoVo;

public interface FlowDefinitionService {

    boolean exist(String processDefinitionKey);

    BaseResponse getProcessDefinition(ModelInfoVo modelInfoVo);

    BaseResponse<String> importBpmnModel(ModelInfoVo modelInfoVo);

    /**
     * 删除流程定义
     *
     * @param deployId 流程部署ID act_ge_bytearray 表中 deployment_id值
     */
    void delete(String deployId);

    BaseResponse activateProcessDefinitionInstanceById(String deployId);

    BaseResponse suspendProcessDefinitionInstanceById(String deployId);
}
