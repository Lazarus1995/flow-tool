package com.sinoiov.zczhgl.flowable.entity.param;

import com.alibaba.fastjson.JSONObject;
import com.sinoiov.zczhgl.common.enums.CaseNodeEnum;
import com.sinoiov.zczhgl.common.exception.BaseException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * 工作流任务处理入参类
 *
 * @author zhangkaiyong
 * @date 2021/07/31 17:21
 */
@Data
@Builder
@ApiModel(description = "工作流任务相关--请求参数")
@NoArgsConstructor
@AllArgsConstructor
public class FlowTaskParam {

    @ApiModelProperty(value = "业务ID，证据编号/案件编号", required = true)
    private String businessKey;

    @ApiModelProperty(value = "当前节点，枚举。见CaseNodeEnum(code字段)", required = true)
    private Integer node;

    @ApiModelProperty("任务意见")
    private String comment;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("附件URL列表")
    private List<String> attachments;

    @ApiModelProperty(value = "处理决定，枚举。见FlowDecisionEnum(type字段)", required = true)
    private Integer decision;

    @ApiModelProperty("业务数据，json对象。")
    private Map<String, Object> bizData = new JSONObject();

    @ApiModelProperty("驳回时的目标节点，兼容驳回到指定节点的情况。默认驳回到上一节点")
    private String targetNode;

    @ApiModelProperty(value = "租户ID，调试字段，正式环境从当前登录用户中获取", hidden = true)
    private Long tenantId;

    @ApiModelProperty(value = "用户ID，调试字段，正式环境从当前登录用户中获取", hidden = true)
    private Long userId;

    /**
     * 入参验证
     */
    public void validate() {
        if (StringUtils.isEmpty(businessKey)) {
            throw new BaseException("业务ID为空");
        }
        if (null == CaseNodeEnum.getByCode(node)) {
            throw new BaseException("当前节点非法");
        }
        if (null == decision) {
            throw new BaseException("处理决定为空");
        }
    }
}
