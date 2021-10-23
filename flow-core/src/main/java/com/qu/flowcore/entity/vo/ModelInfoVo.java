package com.qu.flowcore.entity.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * @Description: 模型查询对象
 * @author: qu
 * @date: 2021.07.12.14:34
 */
@Data
@ApiModel(value = "ModelInfoVo",description = "模型查询对象")
public class ModelInfoVo implements Serializable {
    private static final long serialVersionUID = -2434943659168309903L;

//    private String modelId;
//
//    private String modelKey;
//
    private String resourceName;

    private String category;

    private Long tenantId;
//
//    private String fileName;

    private MultipartFile file;
}
