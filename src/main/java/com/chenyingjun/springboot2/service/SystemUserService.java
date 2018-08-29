package com.chenyingjun.springboot2.service;

import com.chenyingjun.springboot2.dto.SystemUserPageFind;
import com.chenyingjun.springboot2.entity.SystemUser;
import com.chenyingjun.springboot2.exception.BusinessException;
import com.chenyingjun.springboot2.mapper.SystemUserMapper;
import com.chenyingjun.springboot2.utils.GlobalUtil;
import com.chenyingjun.springboot2.vo.SystemUserPageVo;
import com.chenyingjun.springboot2.vo.SystemUserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Cacheable(key="'userId_'+#id", value="user")
    public SystemUserVo info(String id) {
        System.out.println("-------------------------------------------------------");
        if ("123".equals(id)) {
            throw new BusinessException("aaaaa");
        }

        SystemUserVo user = systemUserMapper.info(id);
        SystemUser systemUser = new SystemUser();
        systemUser.setNickName("超级管理员");
        systemUser = systemUserMapper.selectOne(systemUser);
        String title = GlobalUtil.getConfig("systemProfiles.title", "无值");
        return user;
    }

    /**
     * 查询列表
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @return page
     */
    public PageInfo<SystemUserPageVo> page(SystemUserPageFind find, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SystemUserPageVo> systemUserList = systemUserMapper.page(find);
        PageInfo<SystemUserPageVo> page = new PageInfo<>(systemUserList);
        return page;
    }
}
