package com.deepspc.arena.modular.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deepspc.arena.modular.system.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 通知表 Mapper 接口
 * </p>
 */
public interface NoticeMapper extends BaseMapper<Notice> {

    /**
     * 获取通知列表
     */
    Page<Map<String, Object>> list(@Param("page") Page page, @Param("condition") String condition);

}
