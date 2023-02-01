package com.zhangbaohpu.springboot.common.base;

import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface TreeMapper<T extends TreeEntity<T>> extends SuperMapper<T> {
    /**
     * �ҵ������ӽڵ�
     * @param entity
     * @return
     */
    public List<T> findByParentIdsLike(T entity);
    /**
     * �������и��ڵ��ֶ�
     * @param entity
     * @return
     */
    public int updateParentIds(T entity);

    /**
     * ���ݸ���ID��ȡ�Ӽ��б�
     * @param parentId
     * @return
     */
    <T extends TreeEntity<T>> List<T> getChildren(@Param("parentId")String parentId);

}
