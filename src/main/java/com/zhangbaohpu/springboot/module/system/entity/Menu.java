package com.zhangbaohpu.springboot.module.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.zhangbaohpu.springboot.common.base.TreeEntity;
import lombok.Data;

/**
 * <p>
 * 菜单表
 * type：0根目录，1菜单，2按钮
 * </p>
 * @author zhangbaohpu
 */
@TableName("t_menu")
@Data
public class Menu extends TreeEntity<Menu> {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称英文
     */
    @TableField("name_us")
    private String nameUs;
    /**
     * 菜单URL
     */
    private String url;
    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;
    /**
     * 菜单图标
     */
    private String icon;

    private String language;

    public Menu(Integer id){
        super(id);
    }
    public Menu(){
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name=" + name +
                ", nameUs=" + nameUs +
                ", url=" + url +
                ", perms=" + perms +
                ", icon=" + icon +
                ", sort=" + sort +
                ", type=" + type +
                ", language=" + language +
        "}";
    }
}