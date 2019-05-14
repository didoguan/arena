package com.deepspc.arena.modular.system.warpper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deepspc.arena.core.common.constant.factory.ConstantFactory;
import com.deepspc.arena.core.page.PageResult;
import com.deepspc.arena.core.warpper.BaseControllerWrapper;
import com.deepspc.arena.utils.ToolUtil;

import java.util.List;
import java.util.Map;

/**
 * 部门列表的包装
 */
public class DeptWrapper extends BaseControllerWrapper {

    public DeptWrapper(Map<String, Object> single) {
        super(single);
    }

    public DeptWrapper(List<Map<String, Object>> multi) {
        super(multi);
    }

    public DeptWrapper(Page<Map<String, Object>> page) {
        super(page);
    }

    public DeptWrapper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        Long pid = (Long) map.get("pid");

        if (ToolUtil.isEmpty(pid) || pid.equals(0)) {
            map.put("pName", "--");
        } else {
            map.put("pName", ConstantFactory.me().getDeptName(pid));
        }
    }
}
