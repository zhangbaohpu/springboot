package com.zhangbaohpu.springboot.system;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhangbaohpu.springboot.module.system.entity.User;
import com.zhangbaohpu.springboot.module.system.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhangbaohpu
 * @date 2022/12/6 22:02
 * @desc
 */
@SpringBootTest
public class UserTest {
    @Autowired
    UserService userService;

    @Test
    public void inert(){
        User user = new User();
        user.preInsert();
        user.setId(UUID.randomUUID().toString());
        user.setPassword(UUID.fastUUID().toString());
        user.setUserNameCn("小红");
        user.setEmail("xiaohong@163.com");
        userService.save(user);
    }

    @Test
    public void delete(){
        User user = new User();
        boolean b = userService.removeById("user-k3g0a2n8z4q4t0c7s1");
    }

    @Test
    public void getOne(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUserNameCn,"小明");
        User one = userService.getOne(queryWrapper);
        System.out.println(one.toString());
    }

}
