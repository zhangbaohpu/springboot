package com.zhangbaohpu.springboot.module.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zhangbaohpu.springboot.common.base.BaseController;
import com.zhangbaohpu.springboot.common.base.ResultData;
import com.zhangbaohpu.springboot.common.utils.StringUtils;
import com.zhangbaohpu.springboot.module.system.entity.Menu;
import com.zhangbaohpu.springboot.module.system.service.MenuService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统菜单控制器.
 *
 * @author zhangbaohpu
 * @date 2022/12/7 10:53
 */
@Controller
@RequestMapping("/system/menu")
public class MenuController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String prefix ="/project/system/menu"  ;

    @Autowired
    private MenuService menuService;

    @ModelAttribute
    public Menu get(String id) {
        Menu entity = null;
        if (StringUtils.isNotBlank(id)){
            entity = menuService.getById(id);
        }
        if (entity == null){
            entity = new Menu();
        }
        return entity;
    }

    /**
     * 菜单列表.
     */
    @RequiresPermissions("system:menu:list")
    @RequestMapping("")
    String menu(){
        String menu = "/menu";
        return prefix + menu;
    }

    /**
     * 菜单列表.
     *
     * @param parentId
     */
    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:menu:list")
    @ApiOperation(notes = "list", httpMethod = "POST",value = "菜单树列表")
    @ApiImplicitParam(name = "parentId",value = "父id",dataType = "String")
    public Map<String, Object> list(String parentId) {
        Map<String,Object> result = new HashMap<String,Object>();
        QueryWrapper<Menu> query = new QueryWrapper<>();
        if(!StringUtils.isBlank(parentId)){
            query.lambda().eq(Menu::getParentId,parentId);
        }
        query.lambda().orderBy(true,true,Menu::getSort);
        List<Menu> list = menuService.list(query);
        result.put("list",list);
        return result;
    }

    /**
     * 添加菜单.
     */
    @GetMapping("/add/{pId}")
    @RequiresPermissions("system:menu:add")
    @ApiOperation(notes = "add", httpMethod = "GET",value = "添加页面")
    @ApiImplicitParam(name = "pId",value = "父id",dataType = "String")
    public String add(@PathVariable("pId") String pId, Model model){
        model.addAttribute("pId",pId);
        if (pId.equals("0")) {
            model.addAttribute("pName", "根目录");
        } else {
            Menu menu = menuService.getById(pId);//父菜单
            model.addAttribute("pName", menu.getName());
            model.addAttribute("pSort", menu.getSort()+2);
            model.addAttribute("parentIds", menu.getParentIds());
            model.addAttribute("pIsParent", menu.getIsParent());
        }
        String add = "/add";
        return prefix + add;
    }

    /**
     * 保存新菜单.
     *
     * @param menu
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:menu:add")
    @ApiOperation(notes = "save", httpMethod = "POST",value = "Ajax添加")
    public ResultData save(Menu menu) {
        String pIsParent = menu.getIsParent();//父菜单
        menu.preInsert();
        menu.setIsParent("false");
        menu.setParentIds(menu.getParentIds()+menu.getParentId()+",");
        if (menuService.save(menu)) {
            if(pIsParent.equals("false")){ //修改父菜单
                UpdateWrapper<Menu> update = new UpdateWrapper<>();
                update.lambda().eq(Menu::getId,menu.getParentId()).set(Menu::getIsParent,"true");
                menuService.update(update);
            }
            return ResultData.ok();
        }
        return ResultData.error();
    }


    /**
     * 修改菜单.
     *
     * @param menuId
     * @param model
     */
    @GetMapping("/edit/{menuId}")
    @RequiresPermissions("system:menu:edit")
    @ApiOperation(notes = "edit", httpMethod = "GET",value = "修改页面")
    @ApiImplicitParam(name = "menuId",value = "菜单id",dataType = "Integer")
    String edit(@PathVariable("menuId") Integer menuId, Model model) {
        try {
            Menu menu = menuService.getById(menuId);
            model.addAttribute("menu",menu);
            if (menu.getParentId().equals("0")) {
                model.addAttribute("pName", "根目录");
            } else {
                model.addAttribute("pName", menuService.getById(menu.getParentId()).getName());
            }
        }catch (Exception ex){
            logger.error("menuUpdate -=- {}",ex.toString());
        }
        String edit = "/edit";
        return  prefix + edit;
    }

    /**
     * 保存修改.
     *
     * @param menu
     */
    @ResponseBody
    @RequestMapping("/modify")
    @RequiresPermissions("system:menu:edit")
    @ApiOperation(notes = "modify", httpMethod = "POST",value = "Ajax修改")
    public ResultData modify(Menu menu) {
        menu.preUpdate();
        if (menuService.updateById(menu)) {
            return ResultData.ok();
        }
        return ResultData.error();
    }

    /**
     * 删除菜单
     * @param menu
     */
    @ResponseBody
    @RequestMapping("/remove")
    @RequiresPermissions("system:menu:remove")
    @ApiOperation(notes = "delete", httpMethod = "POST",value = "Ajax修改")
    public ResultData remove(Menu menu) {
        if (menuService.removeById(menu.getId())) {
            return ResultData.ok();
        }
        return ResultData.error();
    }

}
