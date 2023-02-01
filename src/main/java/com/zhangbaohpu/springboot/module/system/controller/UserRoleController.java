package com.zhangbaohpu.springboot.module.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.zhangbaohpu.springboot.module.system.service.UserRoleService;
import com.zhangbaohpu.springboot.common.base.BaseController;

/**
 * @author zhangbaohpu
 * @since 2022-12-09
 * @desc 用户角色表 前端控制器
 */
@Controller
@RequestMapping("/system/userRole")
public class UserRoleController extends BaseController {
    @Autowired
    UserRoleService userRoleService;

}
