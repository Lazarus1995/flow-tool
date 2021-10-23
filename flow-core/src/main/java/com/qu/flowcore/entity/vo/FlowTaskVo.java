package com.qu.flowcore.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 工作流VO
 * @author: qu
 * @date: 2021.05.19.15:10
 */
@Data
@ApiModel("工作流任务相关--请求参数")
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class FlowTaskVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("任务Id")
    private String taskId;

    @ApiModelProperty("用户Id")
    private Long userId;

    @ApiModelProperty("任务意见")
    private String comment;

    @ApiModelProperty("任务意见类型")
    private Integer commentType;

    @ApiModelProperty("附件URL列表")
    private List<String> attachments;

    @ApiModelProperty("流程实例Id")
    private String instanceId;

    @ApiModelProperty("节点")
    private String targetKey;

    @ApiModelProperty("流程变量信息")
    private Map<String, Object> values;

    @ApiModelProperty("瞬时变量")
    private Map<String, Object> transientVariables = new HashMap<>();

    @ApiModelProperty("业务数据，json对象。")
    private Map<String, Object> bizData = new HashMap<>();

    @ApiModelProperty("审批人")
    private String assignee;

    @ApiModelProperty("候选人")
    private List<String> candidateUsers;

    @ApiModelProperty("审批组")
    private List<String> candidateGroups;

    @ApiModelProperty("业务ID")
    private String businessKey;

    @ApiModelProperty("流程ID")
    private String processDefinitionId;

    @ApiModelProperty("表单key")
    private String formKey;

    @ApiModelProperty("节点名称")
    private String name;

    @ApiModelProperty("流程名称")
    private String processDefinitionName;

    /**
     * 初审和研判都能跳转到复审，需求要求复审只能跳转到初审，此时主返回节点为xml文件中的初审id，taskReject方法中进行判断
     */
    @ApiModelProperty("双节点中的主返回节点")
    private String mainNode;

    @ApiModelProperty("租户ID")
    private Long tenantId;
}
