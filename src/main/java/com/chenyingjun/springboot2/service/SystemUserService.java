package com.chenyingjun.springboot2.service;

import com.chenyingjun.springboot2.mapper.SystemUserMapper;
import com.chenyingjun.springboot2.vo.SystemUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户 服务
 *
 * @author chenyingjun
 * @Date 2018年08月21日
 * @since 1.0
 */
@Service
public class SystemUserService{

    /**
     * 用户 dao
     */
    @Autowired
    private SystemUserMapper systemUserMapper;

    /**
     * 根据主键查询用户信息
     *
     * @param id 查询信息主键
     * @return 组织列表
     */
    public SystemUserVo info(String id) {
        SystemUserVo user = systemUserMapper.info(id);
        return user;
    }

}
