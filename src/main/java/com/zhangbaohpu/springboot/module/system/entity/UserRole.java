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
 * @desc 用户角色表
 */
@Data
@TableName("t_user_role")
@ApiModel(value = "UserRole对象", description = "用户角色表")
public class UserRole extends BaseEntity<UserRole> {

private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
        @TableId(value = "id", type = IdType.AUTO)
                private Long id;

    @ApiModelProperty("用户id")
    @TableField("user_id")
        private String userId;

    @ApiModelProperty("角色id")
    @TableField("role_id")
        private Long roleId;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserRole{" +
            "id = " + id +
            ", userId = " + userId +
            ", roleId = " + roleId +
        "}";
    }

}