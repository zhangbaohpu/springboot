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
 * @since 2022-12-10
 * @desc 角色表
 */
@Data
@TableName("t_role")
@ApiModel(value = "Role对象", description = "角色表")
public class Role extends BaseEntity<Role> {

private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
        @TableId(value = "id", type = IdType.AUTO)
                private Long id;

    @ApiModelProperty("角色名")
    @TableField("name")
        private String name;

    @ApiModelProperty("角色英文名")
    @TableField("name_us")
        private String nameUs;

    @ApiModelProperty("角色类型")
    @TableField("type")
        private Long type;

    @ApiModelProperty("归属机构id")
    @TableField("org_id")
        private String orgId;

    @ApiModelProperty("是否系统数据，0否，1是")
    @TableField("is_sys")
        private Long isSys;

    @ApiModelProperty("是否可用，0可用，1不可用")
    @TableField("status")
        private Long status;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Role{" +
            "id = " + id +
            ", name = " + name +
            ", nameUs = " + nameUs +
            ", type = " + type +
            ", orgId = " + orgId +
            ", isSys = " + isSys +
            ", status = " + status +
        "}";
    }

}