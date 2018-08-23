package com.chenyingjun.springboot2.mapper;


import com.chenyingjun.springboot2.vo.SystemUserVo;

/**
 * 用户 mapper
 * @author chenyingjun
 * @date 2018年8月23日
 */
public interface SystemUserMapper {
    SystemUserVo info(String id);
}