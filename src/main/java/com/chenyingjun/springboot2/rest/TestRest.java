package com.chenyingjun.springboot2.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(description = "测试swagger2接口")
@Controller
@RequestMapping("/api/test")
public class TestRest {

    @Value("${aaaaa}")
    private String testConfigValue;

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
    public String findByVenueId(@RequestParam String id) {
        return testConfigValue + id;
    }
}
