package com.qu.flowcore.entity.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 工作流任务删除入参类
 *
 * @author qu
 * @date 2021/12/03
 */
@Data
@ApiModel(description = "工作流任务删除入参类")
public class FlowTaskDeleteParam {

    @ApiModelProperty(value = "业务ID，证据编号/案件编号", required = true)
    private String businessKey;

    @ApiModelProperty("任务意见")
    private String processInstanceId;

}
