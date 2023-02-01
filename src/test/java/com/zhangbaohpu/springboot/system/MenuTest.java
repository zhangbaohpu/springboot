package com.zhangbaohpu.springboot.system;

import com.zhangbaohpu.springboot.module.system.entity.Menu;
import com.zhangbaohpu.springboot.module.system.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhangbaohpu
 * @date 2022/12/7 10:55
 * @desc
 */
@SpringBootTest
public class MenuTest {
    @Autowired
    MenuService menuService;

    @Test
    public void insertMenu(){
        Menu menu = new Menu();
        menu.preInsert();
        menu.setName("菜单管理");
        menu.setUrl("/menu/list");
        menu.setParentId(0);
        menu.setIsParent("true");
        menu.setPerms("menu:list");
        menuService.save(menu);
    }

}
