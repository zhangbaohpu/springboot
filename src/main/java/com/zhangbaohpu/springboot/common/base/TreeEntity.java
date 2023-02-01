package com.zhangbaohpu.springboot.common.base;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
public abstract class TreeEntity<T extends Model> extends BaseEntity<T> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    protected Integer id;
    @TableField("parent_id")
    protected Integer parentId;
    @TableField("parent_ids")
    protected String parentIds;
    @TableField("name")
    protected String name;
    @TableField("type")
    protected Integer type;
    @TableField("code")
    protected String code;
    @TableField("sort")
    protected Integer sort;
    @TableField(exist = false)
    private boolean hasChildren;
    @TableField(exist = false)
    protected T parent;
    @TableField("is_parent")
    protected String isParent;

    public TreeEntity() {
        super();
        this.sort = 5;
    }
    public TreeEntity(Integer id) {
        this.id=id;
    }

}
