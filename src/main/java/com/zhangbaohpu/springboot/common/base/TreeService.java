package com.zhangbaohpu.springboot.common.base;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhangbaohpu.springboot.common.exception.ServiceException;
import com.zhangbaohpu.springboot.common.utils.Reflections;
import com.zhangbaohpu.springboot.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public abstract class TreeService<D extends TreeMapper<T>, T extends TreeEntity<T>> extends ServiceImpl<D, T> {

    @Transactional(readOnly = false)
    public boolean save(T entity) {
        boolean falg = false;
        @SuppressWarnings("unchecked")
        Class<T> entityClass = Reflections.getClassGenricType(getClass(), 1);

        // 如果没有设置父节点，则代表为跟节点，有则获取父节点实体
        if (entity.getParentId()==null
                || "0".equals(entity.getParentId())){
            entity.setParent(null);
        }else{
            entity.setParent(super.getById(entity.getParentId()));
        }
        if (entity.getParent() == null){
            T parentEntity = null;
            try {
                parentEntity = entityClass.getConstructor(String.class).newInstance("0");
            } catch (Exception e) {
                throw new ServiceException(e);
            }
            entity.setParent(parentEntity);
            entity.getParent().setParentIds(StringUtils.EMPTY);
        }

        // 获取修改前的parentIds，用于更新子节点的parentIds
        String oldParentIds = entity.getParentIds();

        // 设置新的父节点串
        entity.setParentIds(entity.getParent().getParentIds()+entity.getParent().getId()+",");

        // 保存或更新实体
        if(entity.getId()==null){
            entity.preInsert();
            entity.setIsParent("false");//根节点设置isParent为false
            falg = super.save(entity);

            if(entity.getParentId()!=null&&!entity.getParentId().equals("0")){
                //查找父类对象
                T t =  baseMapper.selectById(entity.getParentId());
                //修改父类的isParent字段，改为"true",标识为父类节点，有子节点信息
                t.setIsParent("true");
                falg = super.updateById(t);
            }

        }else{
            entity.preUpdate();
            falg = super.updateById(entity);
        }

        // 更新子节点 parentIds
        T o = null;
        try {
            o = entityClass.newInstance();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        o.setParentIds("%,"+entity.getId()+",%");
        List<T> list = baseMapper.findByParentIdsLike(o);
        for (T e : list){
            if (e.getParentIds() != null && oldParentIds != null){
                e.setParentIds(e.getParentIds().replace(oldParentIds, entity.getParentIds()));
                preUpdateChild(entity, e);
                baseMapper.updateParentIds(e);
            }
        }
        return falg;
    }

    /**
     * 预留接口，用户更新子节前调用
     * @param childEntity
     */
    protected void preUpdateChild(T entity, T childEntity) {

    }

    public List<T> getChildren(String parentId){
        return baseMapper.getChildren(parentId);
    }
}
