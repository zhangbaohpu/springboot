package com.zhangbaohpu.springboot.module.system.service.impl;

import com.zhangbaohpu.springboot.module.system.entity.Role;
import com.zhangbaohpu.springboot.module.system.mapper.RoleMapper;
import com.zhangbaohpu.springboot.module.system.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author zhangbaohpu
 * @since 2022-12-10
 * @desc 角色表 服务实现类
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
