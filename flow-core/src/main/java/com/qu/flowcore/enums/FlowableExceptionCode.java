package com.qu.flowcore.enums;

/**
 * @Description: Flowable错误返回枚举
 * @author: qu
 * @date: 2021.0.12.15:31
 */
public enum FlowableExceptionCode {

    BPMN_FILE_EXCEPTION("20100","BPMN文件错误"),
    BPMN_FILE_EMPTY_EXCEPTION("20101","BPMN文件为空"),
    BPMN_FILE_READ_EXCEPTION("20102","BPMN文件解析异常，异常内容：%s"),
    BPMN_PROCESSES_EXCEPTION("20103","BPMN定义中未找到流程，BPMN文件名: %s"),
    BPMN_LOCATIONMAP_EXCEPTION("20104","BPMN定义中流程节点异常，BPMN文件名: %s"),
    BPMN_FLOWLOCATIONMAP_EXCEPTION("20105","BPMN定义中流程节点之间连线异常，BPMN文件名: %s"),

    GET_PROCESS_DEFINITION("20200","需要参数TenantId");

    private String code;
    private String msg;

    FlowableExceptionCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
