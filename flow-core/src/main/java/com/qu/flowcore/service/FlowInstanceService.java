package com.qu.flowcore.service;


import com.qu.flowcore.entity.param.FlowStartParam;
import com.qu.flowcore.entity.param.FlowTaskDeleteParam;
import com.qu.flowcore.entity.vo.FlowTaskVo;

public interface FlowInstanceService {

    Boolean startProcessInstance(FlowStartParam param);

    Boolean deleteProcessInstance(FlowTaskDeleteParam param);

    Boolean activateProcessInstanceById(String processInstanceId);

    Boolean suspendProcessInstanceById(String processInstanceId);

    //本来想写终止流程的，暂时不涉及到，而且终止流程有一些复杂，暂时跳过

    /**
     * 结束流程实例
     *
     * @param vo
     */
    void stopProcessInstance(FlowTaskVo vo);

    /**
     * 删除流程实例ID
     *
     * @param instanceId   流程实例ID
     * @param deleteReason 删除原因
     */
    void delete(String instanceId, String deleteReason);

}
