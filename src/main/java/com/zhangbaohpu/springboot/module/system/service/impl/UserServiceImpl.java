package com.zhangbaohpu.springboot.module.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangbaohpu.springboot.module.system.entity.User;
import com.zhangbaohpu.springboot.module.system.mapper.UserMapper;
import com.zhangbaohpu.springboot.module.system.service.UserService;
import org.springframework.stereotype.Service;


/**
 * @author zhangbaohpu
 * @date 2022/12/6 19:45
 * @desc
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
