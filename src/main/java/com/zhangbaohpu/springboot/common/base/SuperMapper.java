package com.zhangbaohpu.springboot.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author zhangbaohpu
 */
public interface SuperMapper<T> extends BaseMapper<T> {
    @Select("${sql}")
    public List<Map<String, Object>> execSelectSqls(@Param(value = "sql") String sql);

    @Select("${sql}")
    public List<Object> execSelectSql(@Param(value = "sql") String sql);
}