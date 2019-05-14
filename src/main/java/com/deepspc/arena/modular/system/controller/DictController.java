package com.deepspc.arena.modular.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deepspc.arena.core.common.annotion.BussinessLog;
import com.deepspc.arena.core.common.annotion.Permission;
import com.deepspc.arena.core.common.constant.Const;
import com.deepspc.arena.core.common.constant.dictmap.DictMap;
import com.deepspc.arena.core.common.constant.factory.ConstantFactory;
import com.deepspc.arena.core.common.page.LayuiPageFactory;
import com.deepspc.arena.core.log.LogObjectHolder;
import com.deepspc.arena.core.reqres.response.ResponseData;
import com.deepspc.arena.modular.base.controller.BaseController;
import com.deepspc.arena.modular.system.model.DictDto;
import com.deepspc.arena.modular.system.service.DictService;
import com.deepspc.arena.modular.system.warpper.DictWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 字典控制器
 *
 */
@Controller
@RequestMapping("/dict")
public class DictController extends BaseController {

    private String PREFIX = "/modular/system/dict/";

    @Autowired
    private DictService dictService;

    /**
     * 跳转到字典管理首页
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:21 PM
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dict.html";
    }

    /**
     * 跳转到添加字典类型
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:21 PM
     */
    @RequestMapping("/dict_add_type")
    public String deptAddType() {
        return PREFIX + "dict_add_type.html";
    }

    /**
     * 跳转到添加字典条目
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:22 PM
     */
    @RequestMapping("/dict_add_item")
    public String deptAddItem(@RequestParam("dictId") Long dictId, Model model) {
        model.addAttribute("dictTypeId", dictId);
        model.addAttribute("dictTypeName", ConstantFactory.me().getDictName(dictId));
        return PREFIX + "dict_add_item.html";
    }

    /**
     * 新增字典
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:22 PM
     */
    @RequestMapping(value = "/add")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public ResponseData add(DictDto dictDto) {
        this.dictService.addDict(dictDto);
        return SUCCESS_TIP;
    }

    /**
     * 获取所有字典列表
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:22 PM
     */
    @RequestMapping(value = "/list")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public Object list(String condition) {
        Page<Map<String, Object>> list = this.dictService.list(condition);
        Page<Map<String, Object>> warpper = new DictWrapper(list).wrap();
        return LayuiPageFactory.createPageInfo(warpper);
    }

    /**
     * 删除字典记录
     *
     * @author fengshuonan
     * @Date 2018/12/23 5:22 PM
     */
    @BussinessLog(value = "删除字典记录", key = "dictId", dict = DictMap.class)
    @RequestMapping(value = "/delete")
    @Permission(Const.ADMIN_NAME)
    @ResponseBody
    public ResponseData delete(@RequestParam Long dictId) {

        //缓存被删除的名称
        LogObjectHolder.me().set(ConstantFactory.me().getDictName(dictId));

        this.dictService.delteDict(dictId);

        return SUCCESS_TIP;
    }

}
