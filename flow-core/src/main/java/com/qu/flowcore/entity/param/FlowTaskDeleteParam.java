package com.sinoiov.zczhgl.flowable.entity.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 工作流任务删除入参类
 *
 * @author zhangkaiyong
 * @date 2021/07/31 17:21
 */
@Data
@ApiModel(description = "工作流任务删除入参类")
public class FlowTaskDeleteParam {

    @ApiModelProperty(value = "业务ID，证据编号/案件编号", required = true)
    private String businessKey;

    @ApiModelProperty("任务意见")
    private String processInstanceId;

}
