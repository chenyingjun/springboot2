package com.chenyingjun.springboot2.mapper;


import com.chenyingjun.springboot2.dto.SystemUserPageFind;
import com.chenyingjun.springboot2.entity.SystemUser;
import com.chenyingjun.springboot2.vo.SystemUserPageVo;
import com.chenyingjun.springboot2.vo.SystemUserVo;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * 用户 mapper
 * @author chenyingjun
 * @date 2018年8月23日
 */
public interface SystemUserMapper extends Mapper<SystemUser>, MySqlMapper<SystemUser> {
    SystemUserVo info(String id);
    List<SystemUserPageVo> page(SystemUserPageFind find);

}