package com.zhangbaohpu.springboot.common.base;

import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TreeMapper<T extends TreeEntity<T>> extends SuperMapper<T> {
    /**
     * 找到所有子节点
     * @param entity
     * @return
     */
    public List<T> findByParentIdsLike(T entity);
    /**
     * 更新所有父节点字段
     * @param entity
     * @return
     */
    public int updateParentIds(T entity);

    /**
     * 根据父级ID获取子级列表
     * @param parentId
     * @return
     */
    <T extends TreeEntity<T>> List<T> getChildren(@Param("parentId")String parentId);

}
