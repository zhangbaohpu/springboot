package com.zhangbaohpu.springboot.module.system.service.impl;

import com.zhangbaohpu.springboot.module.system.entity.RoleMenu;
import com.zhangbaohpu.springboot.module.system.mapper.RoleMenuMapper;
import com.zhangbaohpu.springboot.module.system.service.RoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author zhangbaohpu
 * @since 2022-12-09
 * @desc 角色菜单表 服务实现类
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

}
