package com.deepspc.arena.modular.system.warpper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deepspc.arena.core.common.constant.factory.ConstantFactory;
import com.deepspc.arena.core.page.PageResult;
import com.deepspc.arena.core.warpper.BaseControllerWrapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 角色列表的包装类
 *
 */
public class RoleWrapper extends BaseControllerWrapper {

    public RoleWrapper(Map<String, Object> single) {
        super(single);
    }

    public RoleWrapper(List<Map<String, Object>> multi) {
        super(multi);
    }

    public RoleWrapper(Page<Map<String, Object>> page) {
        super(page);
    }

    public RoleWrapper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        map.put("pName", ConstantFactory.me().getSingleRoleName(((BigDecimal) map.get("pid")).longValue()));
        if (null != map.get("deptId")) {
            map.put("deptName", ConstantFactory.me().getDeptName(((BigDecimal) map.get("deptId")).longValue()));
        }
    }

}
