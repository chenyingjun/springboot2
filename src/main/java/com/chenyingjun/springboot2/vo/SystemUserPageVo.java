package com.chenyingjun.springboot2.vo;

import com.chenyingjun.springboot2.enums.SexType;
import com.chenyingjun.springboot2.enums.StatusType;
import com.chenyingjun.springboot2.utils.DateUtil;
import com.chenyingjun.springboot2.utils.LoggerUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;

@Data
public class SystemUserPageVo {

    private String id;

    private String name;

    private String nickName;

    private String email;

    private String phone;

    private String sex;

    private String sexName;

    private String failNum;

    private Integer status;

    private String statusName;

    private String createTime;

    private String updateTime;

    private String rolesName;

    public void setSex(String sex) {
        this.sex = sex;
        this.sexName = SexType.getName(sex);
    }

    public void setStatus(Integer status) {
        this.status = status;
        if (null != status) {
            this.statusName = StatusType.getName(status);
        }
    }

    public void setCreateTime(String createTime) {
        if (StringUtils.isNotBlank(createTime)) {
            try {
                this.createTime = DateUtil.parseToFormatStr(createTime, DateUtil.FULL_DATE_STR);
            } catch (ParseException e) {
                LoggerUtil.error(getClass(), "时间格式化失败");
                this.createTime = createTime;
            }
        }
    }

    public void setUpdateTime(String updateTime) {
        if (StringUtils.isNotBlank(updateTime)) {
            try {
                this.updateTime = DateUtil.parseToFormatStr(updateTime, DateUtil.SIMPLE_DATE_STR);
            } catch (ParseException e) {
                LoggerUtil.error(getClass(), "时间格式化失败");
                this.updateTime = updateTime;
            }
        }
    }
}
