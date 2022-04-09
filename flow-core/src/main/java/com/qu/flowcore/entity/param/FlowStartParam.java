package com.qu.flowcore.entity.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 启动流程实例接口入参
 *
 * @author qu
 * @date 2021/12/03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "启动流程实例接口入参")
public class FlowStartParam {

    @ApiModelProperty("流程所属节点，枚举。见CaseNodeEnum的name()属性")
    private String processDefinitionName;

    @ApiModelProperty("业务ID")
    private String businessKey;

    @ApiModelProperty("租户ID，从当前登录用户中获取")
    private Long tenantId;

    @ApiModelProperty("流程发起人ID，从当前登录用户中获取")
    private Long userId;

    @ApiModelProperty("流程变量")
    private Map<String, Object> variables = new HashMap<>();
}
