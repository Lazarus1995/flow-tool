package com.qu.flowcore.entity.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 审批历史查询入参
 *
 * @author qu
 * @date 2021/12/03
 */
@Data
@ApiModel(description = "审批历史查询出参")
public class TaskHistoriesParam {

    @ApiModelProperty(value = "业务ID", required = true)
    private String businessKey;

    @ApiModelProperty(value = "当前节点，枚举")
    private Integer node;
}
