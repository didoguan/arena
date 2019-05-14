package com.deepspc.arena.modular.system.warpper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deepspc.arena.core.common.constant.factory.ConstantFactory;
import com.deepspc.arena.core.warpper.BaseControllerWrapper;
import com.deepspc.arena.modular.system.entity.Dict;

import java.util.List;
import java.util.Map;

/**
 * 字典列表的包装
 *
 */
public class DictWrapper extends BaseControllerWrapper {

    public DictWrapper(Page<Map<String, Object>> page) {
        super(page);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        StringBuilder detail = new StringBuilder();
        Long id = Long.valueOf(map.get("dictId").toString());
        List<Dict> dicts = ConstantFactory.me().findInDict(id);
        if (dicts != null) {
            for (Dict dict : dicts) {
                detail.append(dict.getCode()).append(":").append(dict.getName()).append(",");
            }
            map.put("detail", StrUtil.removeSuffix(detail.toString(), ","));
        }
    }
}
