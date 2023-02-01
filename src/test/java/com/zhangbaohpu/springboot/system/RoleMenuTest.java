package com.zhangbaohpu.springboot.system;

import com.zhangbaohpu.springboot.module.system.entity.RoleMenu;
import com.zhangbaohpu.springboot.module.system.service.RoleMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhangbaohpu
 * @date 2022/12/7 16:03
 * @desc
 */
@SpringBootTest
public class RoleMenuTest {

    @Autowired
    RoleMenuService roleMenuService;

    @Test
    public void insert(){
        RoleMenu roleMenu = new RoleMenu();
    }
}
