package com.sinoiov.zczhgl.flowable.entity.param;

import com.sinoiov.zczhgl.common.enums.CaseNodeEnum;
import com.sinoiov.zczhgl.common.exception.BaseException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 审批历史查询入参
 *
 * @author zhangkaiyong
 * @date 2021/08/09 14:10
 */
@Data
@ApiModel(description = "审批历史查询出参")
public class TaskHistoriesParam {

    @ApiModelProperty(value = "业务ID，证据编号/案件编号", required = true)
    private String businessKey;

    @ApiModelProperty(value = "当前节点，枚举。见CaseNodeEnum(code字段)")
    private Integer node;

    /**
     * 入参验证
     */
    public void validate() {
        if (StringUtils.isEmpty(businessKey)) {
            throw new BaseException("业务ID为空");
        }
        if (null != node && null == CaseNodeEnum.getByCode(node)) {
            throw new BaseException("当前节点非法");
        }
    }
}
