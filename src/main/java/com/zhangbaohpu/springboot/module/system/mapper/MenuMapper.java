package com.zhangbaohpu.springboot.module.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhangbaohpu.springboot.module.system.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zhangbaohpu
 * @date 2022/12/7 10:49
 * @desc
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> listMenu(@Param("map") Map<String,Object> map);
}
