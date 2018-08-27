package com.chenyingjun.springboot2.controller;

import com.chenyingjun.springboot2.dto.SystemUserPageFind;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * 界面测试信息
 * @author chenyingjun
 * @date 2018年8月25日
 */
@Controller
@RequestMapping("/admin/test")
public class TestController {
    /**
     *
     * @Title:
     * @Description: 页面
     * @return 页面
     */
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ModelAndView goPage(SystemUserPageFind find) {
        return new ModelAndView("sign");
    }

}
