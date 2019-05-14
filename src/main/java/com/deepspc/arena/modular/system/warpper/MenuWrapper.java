package com.deepspc.arena.modular.system.warpper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deepspc.arena.core.common.constant.factory.ConstantFactory;
import com.deepspc.arena.core.enums.YesOrNotEnum;
import com.deepspc.arena.core.page.PageResult;
import com.deepspc.arena.core.warpper.BaseControllerWrapper;

import java.util.List;
import java.util.Map;

/**
 * 菜单列表的包装类
 *
 */
public class MenuWrapper extends BaseControllerWrapper {

    public MenuWrapper(Map<String, Object> single) {
        super(single);
    }

    public MenuWrapper(List<Map<String, Object>> multi) {
        super(multi);
    }

    public MenuWrapper(Page<Map<String, Object>> page) {
        super(page);
    }

    public MenuWrapper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        map.put("statusName", ConstantFactory.me().getMenuStatusName((String) map.get("status")));

        String menuFlag = (String) map.get("menuFlag");
        for (YesOrNotEnum value : YesOrNotEnum.values()) {
            if(value.name().equals(menuFlag)){
                map.put("isMenuName", value.getDesc());
            }
        }
    }

}
