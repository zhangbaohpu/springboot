package com.zhangbaohpu.springboot.module.system.service.impl;

import com.zhangbaohpu.springboot.module.system.entity.UserRole;
import com.zhangbaohpu.springboot.module.system.mapper.UserRoleMapper;
import com.zhangbaohpu.springboot.module.system.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author zhangbaohpu
 * @since 2022-12-09
 * @desc 用户角色表 服务实现类
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
