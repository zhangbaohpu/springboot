package com.zhangbaohpu.springboot.module.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.zhangbaohpu.springboot.module.system.service.RoleService;
import com.zhangbaohpu.springboot.common.base.BaseController;

/**
 * @author zhangbaohpu
 * @since 2022-12-10
 * @desc 角色表 前端控制器
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController {
    @Autowired
    RoleService RoleService;

}
