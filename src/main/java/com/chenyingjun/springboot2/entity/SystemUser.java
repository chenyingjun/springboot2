package com.chenyingjun.springboot2.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 用户信息
 * @author chenyingjun
 * @date 2018年8月23日
 */
@Data
public class SystemUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value = "用户姓名")
    private String name;

    /**
     * 登录名
     */
    @ApiModelProperty(value = "登录名")
    private String account;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    /**
     * 登录密码
     */
    @ApiModelProperty(value = "登录密码")
    private String passWord;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 性别,1.男;2.女
     */
    @ApiModelProperty(value = "性别,1.男;2.女")
    private String sex;

    /**
     * 登录失败次数
     */
    @ApiModelProperty(value = "登录失败次数")
    private Integer failNum;

    /**
     * 状态  1.可用;0.禁用
     */
    @ApiModelProperty(value = "状态  1.可用;0.禁用")
    private Integer status;

    /**
     * 此次登录时间
     */
    @ApiModelProperty(value = "此次登录时间")
    private Date loginTime;

    /**
     * 此次登录IP
     */
    @ApiModelProperty(value = "此次登录IP")
    private String loginIp;

    /**
     * 上次登录时间
     */
    @ApiModelProperty(value = "上次登录时间")
    private Date lastTime;

    /**
     * 上次登录IP
     */
    @ApiModelProperty(value = "上次登录IP")
    private String lastIp;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 构建函数
     */
    public SystemUser() {
    }

    /**
     * 构建函数
     */
    public SystemUser(SystemUser user) {
    }

    /**
     * 字符串化
     * @return 对象字符串
     */
    @Override
    public String toString() {
        return "SystemUser{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", failNum=" + failNum +
                ", status=" + status +
                ", loginTime=" + loginTime +
                ", loginIp='" + loginIp + '\'' +
                ", lastTime=" + lastTime +
                ", lastIp='" + lastIp + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}