package com.zhangbaohpu.springboot.module.home;

import com.google.common.collect.Maps;
import com.zhangbaohpu.springboot.common.base.BaseController;
import com.zhangbaohpu.springboot.common.base.Tree;
import com.zhangbaohpu.springboot.module.system.entity.Menu;
import com.zhangbaohpu.springboot.module.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * @author zhangbaohpu
 * @date 2022/12/7 17:51
 * @desc
 */
@Controller
public class HomeController extends BaseController {
    @Autowired
    MenuService menuService;

    @GetMapping("/home")
    public String index(Model model){
        Map<String,Object> map = Maps.newHashMap();
//        map.put("userId",getUserId());
        List<Tree<Menu>> menus = menuService.listMenuTree(map);
        model.addAttribute("menus", menus);
        return "index";
    }
}
