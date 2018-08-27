package com.chenyingjun.springboot2.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 基础信息
 *
 * @author chenyingjun
 * @version 2017年05月05日
 * @since 1.0
 */
@Data
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    /** 0:已删除  */
    public static final int DEL_FLAG_0 = 0;
    /** 1:可用 */
    public static final int DEL_FLAG_1 = 1;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator="UUID")
    private String id;

    /**
     * 是否删除   0.已删除；1.可用
     */
    @ApiModelProperty(value = "是否删除   0.已删除；1.可用")
    private int delFlag;
}
