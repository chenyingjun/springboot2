package com.chenyingjun.springboot2.rest;

import com.chenyingjun.springboot2.bean.JsonResponse;
import com.chenyingjun.springboot2.dto.SystemUserPageFind;
import com.chenyingjun.springboot2.service.SystemUserService;
import com.chenyingjun.springboot2.vo.SystemUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
        return vo;
    }
}
