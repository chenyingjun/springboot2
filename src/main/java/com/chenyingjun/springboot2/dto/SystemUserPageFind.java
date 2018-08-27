package com.chenyingjun.springboot2.dto;

import com.chenyingjun.springboot2.validator.NotXss;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "用户列表查询")
public class SystemUserPageFind implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotXss
    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "呢称")
    private String nickName;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "失败次数")
    private Integer failNum;

    @ApiModelProperty(value = "状态")
    private Integer userStatus;

    @ApiModelProperty(value = "开始时间")
    @Pattern(regexp = "([1-2]{1}[0-9]{3})((1[0-2]{1})|(0[1-9]{1}))((0[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-1]{1}))",
            message = "请按指定格式输入")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    @Pattern(regexp = "([1-2]{1}[0-9]{3})((1[0-2]{1})|(0[1-9]{1}))((0[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-1]{1}))",
            message = "{data.input}")
    private String endTime;

    @ApiModelProperty(value = "角色主键集")
    private List<String> roleIds;
}
