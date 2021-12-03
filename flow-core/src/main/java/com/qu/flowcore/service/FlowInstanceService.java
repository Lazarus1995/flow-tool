package com.sinoiov.zczhgl.flowable.service;

import com.sinoiov.zczhgl.common.response.BaseResponse;
import com.sinoiov.zczhgl.flowable.entity.param.FlowStartParam;
import com.sinoiov.zczhgl.flowable.entity.param.FlowTaskDeleteParam;
import com.sinoiov.zczhgl.flowable.entity.vo.FlowTaskVo;
import org.flowable.engine.history.HistoricProcessInstance;

public interface FlowInstanceService {



    BaseResponse<String> startProcessInstance(FlowStartParam param);

    BaseResponse deleteProcessInstance(FlowTaskDeleteParam param);

    BaseResponse activateProcessInstanceById(String processInstanceId);

    BaseResponse suspendProcessInstanceById(String processInstanceId);

    //本来想写终止流程的，一期项目暂时不涉及到，而且终止流程有一些复杂，暂时跳过

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

    /**
     * 根据实例ID查询历史实例数据
     *
     * @param processInstanceId
     * @return
     */
    HistoricProcessInstance getHistoricProcessInstanceById(String processInstanceId);
}
