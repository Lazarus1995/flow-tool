package com.qu.flowcore.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 审批历史查询出参
 *
 * @author zhangkaiyong
 * @date 2021/08/09 11:03
 */
@Data
@ApiModel(description = "审批历史查询出参")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskHistoriesVO {

    @ApiModelProperty(value = "业务ID，证据编号/案件编号")
    private String businessKey;

    @ApiModelProperty(value = "审批任务ID")
    private String taskId;

    @ApiModelProperty(value = "审批任务名称")
    private String taskName;

    @ApiModelProperty(value = "处理人员", required = true)
    private String handleId;

    @ApiModelProperty(value = "处理人员", required = true)
    private String handleName;

    @ApiModelProperty(value = "处理时间", required = true)
    private Long handleTime;

    @ApiModelProperty(value = "执法证号", required = true)
    private String handleNo;

    @ApiModelProperty(value = "所属组织", required = true)
    private Long organizationId;

    @ApiModelProperty(value = "组织名称", required = true)
    private String organizationName;

    @ApiModelProperty(value = "处理环节，枚举。见CaseNodeEnum(code字段)", required = true)
    private Integer node;

    @ApiModelProperty(value = "处理环节描述")
    private String nodeDesc;

    @ApiModelProperty("案件处置结果")
    private String result;

    @ApiModelProperty("处理决定，枚举。见FlowDecisionEnum(type字段)")
    private Integer decision;

    @ApiModelProperty("处理决定描述")
    private String decisionDesc;

    @ApiModelProperty("处置意见")
    private String comment;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("审批附件")
    private List<AttachmentVo> attachments;
}
