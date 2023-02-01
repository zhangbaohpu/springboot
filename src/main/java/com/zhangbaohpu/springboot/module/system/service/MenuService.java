package com.zhangbaohpu.springboot.module.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhangbaohpu.springboot.common.base.Tree;
import com.zhangbaohpu.springboot.module.system.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * @author zhangbaohpu
 * @date 2022/12/7 10:50
 * @desc
 */
public interface MenuService extends IService<Menu> {
    List<Tree<Menu>> listMenuTree(Map<String,Object>  map);
}
