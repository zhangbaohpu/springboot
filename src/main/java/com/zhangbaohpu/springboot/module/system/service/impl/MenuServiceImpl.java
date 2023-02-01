package com.zhangbaohpu.springboot.module.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.zhangbaohpu.springboot.common.base.Tree;
import com.zhangbaohpu.springboot.common.utils.BuildTree;
import com.zhangbaohpu.springboot.module.system.entity.Menu;
import com.zhangbaohpu.springboot.module.system.mapper.MenuMapper;
import com.zhangbaohpu.springboot.module.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author zhangbaohpu
 * @date 2022/12/7 10:51
 * @desc
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {



    @Override
    public List<Tree<Menu>> listMenuTree(Map<String,Object> map) {
        List<Tree<Menu>> trees = new ArrayList<Tree<Menu>>();
        List<Menu> menuDOs = new ArrayList<>();

        menuDOs = baseMapper.listMenu(map);


        for (Menu sysMenuDO : menuDOs) {
            if (sysMenuDO == null) {
                continue;
            }
            Tree<Menu> tree = new Tree<Menu>();
            tree.setId(sysMenuDO.getId()!=null?sysMenuDO.getId().toString():null);
            tree.setParentId(sysMenuDO.getParentId()!=null?sysMenuDO.getParentId().toString():null);
            tree.setText(sysMenuDO.getName());
            Map<String, Object> attributes = new HashMap<>(16);
            attributes.put("url", sysMenuDO.getUrl());
            attributes.put("icon", sysMenuDO.getIcon());
            tree.setAttributes(attributes);
            trees.add(tree);
        }

        // 默认顶级菜单为０，根据数据库实际情况调整
        List<Tree<Menu>> list = BuildTree.buildList(trees, "0");
        return list;
    }
}
