package com.qu.flowcore.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 审批意见
 * @author: qu
 * @date: 2021.05.19.15:01
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlowCommentDto {
    /**
     * 处理决定，枚举。见FlowDecisionEnum
     */
    private Integer decision;
    /**
     * 处置意见
     */
    private String comment;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 处置结果，枚举。见FlowResultEnum
     */
    private String result;
}
