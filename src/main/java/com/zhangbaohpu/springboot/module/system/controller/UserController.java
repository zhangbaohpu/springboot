package com.zhangbaohpu.springboot.module.system.controller;

import com.zhangbaohpu.springboot.common.base.BaseController;
import com.zhangbaohpu.springboot.module.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangbaohpu
 * @date 2022/12/6 19:53
 * @desc
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;


}




