package com.zhangbaohpu.springboot.module.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhangbaohpu.springboot.common.base.BaseEntity;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhangbaohpu
 * @since 2022-12-09
 * @desc 角色菜单表
 */
@Data
@TableName("t_role_menu")
@ApiModel(value = "RoleMenu对象", description = "角色菜单表")
public class RoleMenu extends BaseEntity<RoleMenu> {

private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
        @TableId(value = "id", type = IdType.AUTO)
                private Long id;

    @ApiModelProperty("角色id")
    @TableField("role_id")
        private Long roleId;

    @ApiModelProperty("菜单id")
    @TableField("menu_id")
        private Long menuId;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
            "id = " + id +
            ", roleId = " + roleId +
            ", menuId = " + menuId +
        "}";
    }

}