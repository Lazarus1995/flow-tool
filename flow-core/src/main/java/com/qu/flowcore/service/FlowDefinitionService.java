package com.qu.flowcore.service;

import com.qu.flowcore.entity.vo.ModelInfoVo;

public interface FlowDefinitionService {

    Boolean exist(String processDefinitionKey);

    Boolean getProcessDefinition(ModelInfoVo modelInfoVo);

    Boolean importBpmnModel(ModelInfoVo modelInfoVo);

    /**
     * 删除流程定义
     *
     * @param deployId 流程部署ID act_ge_bytearray 表中 deployment_id值
     */
    void delete(String deployId);

    Boolean activateProcessDefinitionInstanceById(String deployId);

    Boolean suspendProcessDefinitionInstanceById(String deployId);
}
