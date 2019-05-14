package com.deepspc.arena.modular.system.warpper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deepspc.arena.core.common.constant.factory.ConstantFactory;
import com.deepspc.arena.core.page.PageResult;
import com.deepspc.arena.core.warpper.BaseControllerWrapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 部门列表的包装
 *
 */
public class NoticeWrapper extends BaseControllerWrapper {

    public NoticeWrapper(Map<String, Object> single) {
        super(single);
    }

    public NoticeWrapper(List<Map<String, Object>> multi) {
        super(multi);
    }

    public NoticeWrapper(Page<Map<String, Object>> page) {
        super(page);
    }

    public NoticeWrapper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        Long creater = ((BigDecimal) map.get("createUser")).longValue();
        map.put("createrName", ConstantFactory.me().getUserNameById(creater));
    }
}
