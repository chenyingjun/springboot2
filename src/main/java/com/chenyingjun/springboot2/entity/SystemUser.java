package com.chenyingjun.springboot2.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 * @author chenyingjun
 * @date 2018年8月23日
 */
@Data
public class SystemUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator="UUID")
    private String id;

    /**
     * 是否删除   0.已删除；1.可用
     */
    private int delFlag;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 登录名
     */
    private String account;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 登录密码
     */
    private String passWord;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 性别,1.男;2.女
     */
    private String sex;

    /**
     * 登录失败次数
     */
    private Integer failNum;

    /**
     * 状态  1.可用;0.禁用
     */
    private Integer status;

    /**
     * 此次登录时间
     */
    private Date loginTime;

    /**
     * 此次登录IP
     */
    private String loginIp;

    /**
     * 上次登录时间
     */
    private Date lastTime;

    /**
     * 上次登录IP
     */
    private String lastIp;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 备注
     */
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