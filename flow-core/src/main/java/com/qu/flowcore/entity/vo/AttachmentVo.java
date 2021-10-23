package com.qu.flowcore.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 审批附件  视图层类
 *
 * @author zhangkaiyong
 * @date 2021/09/02 16:17
 */
@Data
@ApiModel(description = "审批附件视图层类")
public class AttachmentVo {

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "文件路径")
    private String path;

    @ApiModelProperty(value = "类型，枚举")
    private String classify;

    @ApiModelProperty(value = "类型描述")
    private String classifyDesc;

}
