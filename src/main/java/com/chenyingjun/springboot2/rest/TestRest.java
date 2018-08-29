package com.chenyingjun.springboot2.rest;

import com.chenyingjun.springboot2.bean.JsonResponse;
import com.chenyingjun.springboot2.dto.SystemUserPageFind;
import com.chenyingjun.springboot2.service.SystemUserService;
import com.chenyingjun.springboot2.vo.SystemUserPageVo;
import com.chenyingjun.springboot2.vo.SystemUserVo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 测试
 * @author chenyingjun
 * @date 2018年8月23日
 */
@Api(description = "测试swagger2接口")
@Controller
@RequestMapping("/api/test")
public class TestRest {

    @Value("${systemProfiles.title}")
    private String testConfigValue;

    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 测试信息
     * @param id 主键
     * @return list
     */
    @RequestMapping(value = "id", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "测试信息", notes = "测试信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "主键", dataType = "String"),})
    public JsonResponse findById(@RequestParam String id, @Valid SystemUserPageFind find) {
        return new JsonResponse(testConfigValue + id);
    }

    /**
     * 测试信息
     * @param id 主键
     * @return list
     */
    @RequestMapping(value = "id1", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "测试信息", notes = "测试信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "主键", dataType = "String"),})
    public SystemUserVo findById1(@RequestParam String id, @Valid SystemUserPageFind find) {
        SystemUserVo vo = systemUserService.info(id);
        Object obj = stringRedisTemplate.opsForValue().get("user::userId_" + id);
        Object obj1 = redisTemplate.opsForValue().get("user::userId_" + id);
        System.out.println(obj);
        return (SystemUserVo) obj1;
    }

    /**
     * 查询列表
     * @param pageNum 当前页码
     * @param pageSize 每页数量
     * @return page
     */
    @RequestMapping(value = "page", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询列表", notes = "查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "当前页码", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页数量", dataType = "int"),})
    public PageInfo<SystemUserPageVo> page(SystemUserPageFind find, int pageNum, int pageSize) {
       return systemUserService.page(find, pageNum, pageSize);
    }
}
