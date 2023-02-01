package com.zhangbaohpu.springboot.module.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhangbaohpu.springboot.common.annotation.ExcelField;
import com.zhangbaohpu.springboot.common.base.BaseEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户表
 * </p>
 * @author zhangbaohpu
 */
@Data
@TableName("t_user")
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名，主键
     */
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    @ExcelField(title = "*用户名", align = 2, type = 0, sort = 1)
    private String id;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 中文名称
     */
    @TableField("user_name_cn")
    @ExcelField(title = "*姓名", align = 2, type = 0, sort = 2)
    private String userNameCn;
    /**
     * 英文名称
     */
    @TableField("user_name_en")
    private String userNameEn;
    /**
     * 用户状态
     */
    private Integer status;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 生日
     */
    private Date birth;
    /**
     * 邮箱
     */
    @ExcelField(title = "邮箱", align = 2, type = 0, sort = 5)
    private String email;
    /**
     * 手机号码
     */
    @ExcelField(title = "*手机号码", align = 2, type = 0, sort = 3)
    private String mobile;
    /**
     * 邮政编码
     */
    @TableField("zip_code")
    private String zipCode;
    /**
     * 地址
     */
    @ExcelField(title = "地址", align = 2, type = 0, sort = 10)
    private String address;
    /**
     * 现住址
     */
    @TableField("address_now")
    private String addressNow;

    /**
     * 身份证
     */
    @TableField("identity_card")
    private String identityCard;
    /**
     * 籍贯
     */
    @TableField("native_place")
    private String nativePlace;
    /**
     * 国家
     */
    private String country;
    /**
     * 省份
     */
    @ExcelField(title = "*省份", align = 2, type = 0, sort = 7)
    private String province;
    /**
     * 城市
     */
    @ExcelField(title = "*市", align = 2, type = 0, sort = 8)
    private String city;
    /**
     * 乡镇
     */
    @ExcelField(title = "县/区", align = 2, type = 0, sort = 9)
    private String town;
    /**
     * 用户类型
     */
    @TableField("user_type")
    private String userType;

    /**
     * 个人简介
     */
    @TableField("introduction")
    private String introduction;
    /**
     * 用户头像(用户信息修改时的头像)
     */
    private String photo;
    /**
     * 最后登陆IP
     */
    @TableField("login_ip")
    private String loginIp;
    /**
     * 最后登陆时间
     */
    @TableField("login_date")
    private Date loginDate;
    /**
     * 版本
     */
    private Integer version;


    @TableField(exist = false)
    private String oldPassword;
    @TableField(exist = false)
    private List<String> roleIds;
    @TableField(exist = false)
    private String userTypeName;


    public static boolean isAdmin(String id) {
        return (id != null && "admin".equals(id));
    }


    public User(String id) {
        this.id=id;
    }
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password=" + password +
                ", userNameCn=" + userNameCn +
                ", userNameEn=" + userNameEn +
                ", status=" + status +
                ", age=" + age +
                ", sex=" + sex +
                ", birth=" + birth +
                ", email=" + email +
                ", mobile=" + mobile +
                ", zipCode=" + zipCode +
                ", address=" + address +
                ", addressNow=" + addressNow +
                ", identityCard=" + identityCard +
                ", nativePlace=" + nativePlace +
                ", country=" + country +
                ", province=" + province +
                ", city=" + city +
                ", town=" + town +
                ", userType=" + userType +
                ", photo=" + photo +
                ", loginIp=" + loginIp +
                ", loginDate=" + loginDate +
                ", version=" + version +
                "}";
    }
}