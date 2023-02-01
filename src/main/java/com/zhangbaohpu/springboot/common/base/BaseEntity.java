package com.zhangbaohpu.springboot.common.base;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zhangbaohpu.springboot.common.utils.ShiroUtils;
import com.zhangbaohpu.springboot.common.utils.StringUtils;
import com.zhangbaohpu.springboot.module.system.entity.User;
import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

/**
 * @author zhangbaohpu
 */
@Data
public abstract class BaseEntity<T extends Model> extends Model {

    private static final long serialVersionUID = 1L;

    @TableField("remarks")
    protected String remarks;
    @TableField("create_by")
    protected String createBy;
    @TableField("create_date")
    protected Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("update_by")
    protected String updateBy;
    @TableField("update_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date updateDate;
    @TableField("del_flag")
    @TableLogic(delval = "1")
    protected Integer delFlag;

    /**
     * 当前用户
     */
    @TableField(exist = false)
    protected User currentUser;
    /**
     * 自定义SQL（SQL标识，SQL内容）
     */
    @TableField(exist = false)
    protected String dataScope;

    public BaseEntity() {
        this.delFlag = DEL_FLAG_NORMAL;
    }

    @JsonIgnore
    @XmlTransient
    public User getCurrentUser() {
        try {
            if(currentUser == null){
                currentUser = ShiroUtils.getUser();
            }
        } catch (Exception e) {
            if(currentUser==null) {
                currentUser = new User("admin");
            }
            e.printStackTrace();
        }
        return currentUser;
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsertApp(String username){
        User user = new User(username);
        if (StringUtils.isNotBlank(user.getId())){
            this.updateBy = user.getId();
            this.createBy = user.getId();
        }
        this.updateDate = new Date();
        this.createDate = this.updateDate;

    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdateApp(String username){
        User user = new User(username);
        if (StringUtils.isNotBlank(user.getId())){
            this.updateBy = user.getId();
        }
        this.updateDate = new Date();
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert(){
        User user = null;
        try{
            user = ShiroUtils.getUser();
        }catch (Exception e){
            user = new User("admin");
        }
        if(user==null){
            user = new User("admin");
        }
        if (StringUtils.isNotBlank(user.getId())){
            this.updateBy = user.getId();
            this.createBy = user.getId();
        }
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate(){
        User user = null;
        try{
            user = ShiroUtils.getUser();
        }catch (Exception e){
            user = new User("admin");
        }
        if(user==null){
            user = new User("admin");
        }
        if (StringUtils.isNotBlank(user.getId())){
            this.updateBy = user.getId();
        }
        this.updateDate = new Date();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    public static final int DEL_FLAG_NORMAL = 0;
    public static final int DEL_FLAG_DELETE = 1;
    public static final int DEL_FLAG_AUDIT = 2;




}