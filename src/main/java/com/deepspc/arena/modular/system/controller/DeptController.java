package com.deepspc.arena.modular.system.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deepspc.arena.core.common.annotion.BussinessLog;
import com.deepspc.arena.core.common.annotion.Permission;
import com.deepspc.arena.core.common.constant.dictmap.DeptDict;
import com.deepspc.arena.core.common.constant.factory.ConstantFactory;
import com.deepspc.arena.core.common.node.TreeviewNode;
import com.deepspc.arena.core.common.node.ZTreeNode;
import com.deepspc.arena.core.common.page.LayuiPageFactory;
import com.deepspc.arena.core.exception.RequestEmptyException;
import com.deepspc.arena.core.log.LogObjectHolder;
import com.deepspc.arena.core.reqres.response.ResponseData;
import com.deepspc.arena.core.tree.DefaultTreeBuildFactory;
import com.deepspc.arena.modular.base.controller.BaseController;
import com.deepspc.arena.modular.system.entity.Dept;
import com.deepspc.arena.modular.system.model.DeptDto;
import com.deepspc.arena.modular.system.service.DeptService;
import com.deepspc.arena.modular.system.warpper.DeptTreeWrapper;
import com.deepspc.arena.modular.system.warpper.DeptWrapper;
import com.deepspc.arena.utils.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 部门控制器
 *
 */
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController {

    private String PREFIX = "/modular/system/dept/";

    @Autowired
    private DeptService deptService;

    /**
     * 跳转到部门管理首页
     *
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dept.html";
    }

    /**
     * 跳转到添加部门
     *
     */
    @RequestMapping("/dept_add")
    public String deptAdd() {
        return PREFIX + "dept_add.html";
    }

    /**
     * 跳转到修改部门
     *
     */
    @Permission
    @RequestMapping("/dept_update")
    public String deptUpdate(@RequestParam("deptId") Long deptId) {

        if (ToolUtil.isEmpty(deptId)) {
            throw new RequestEmptyException();
        }

        //缓存部门修改前详细信息
        Dept dept = deptService.getById(deptId);
        LogObjectHolder.me().set(dept);

        return PREFIX + "dept_edit.html";
    }

    /**
     * 获取部门的tree列表，ztree格式
     *
     */
    @RequestMapping(value = "/tree")
    @ResponseBody
    public List<ZTreeNode> tree() {
        List<ZTreeNode> tree = this.deptService.tree();
        tree.add(ZTreeNode.createParent());
        return tree;
    }

    /**
     * 获取部门的tree列表，treeview格式
     *
     */
    @RequestMapping(value = "/treeview")
    @ResponseBody
    public List<TreeviewNode> treeview() {
        List<TreeviewNode> treeviewNodes = this.deptService.treeviewNodes();

        //构建树
        DefaultTreeBuildFactory<TreeviewNode> factory = new DefaultTreeBuildFactory<>();
        factory.setRootParentId("0");
        List<TreeviewNode> results = factory.doTreeBuild(treeviewNodes);

        //把子节点为空的设为null
        DeptTreeWrapper.clearNull(results);

        return results;
    }

    /**
     * 新增部门
     *
     */
    @BussinessLog(value = "添加部门", key = "simpleName", dict = DeptDict.class)
    @RequestMapping(value = "/add")
    @Permission
    @ResponseBody
    public ResponseData add(Dept dept) {
        this.deptService.addDept(dept);
        return SUCCESS_TIP;
    }

    /**
     * 获取所有部门列表
     */
    @RequestMapping(value = "/list")
    @Permission
    @ResponseBody
    public Object list(@RequestParam(value = "condition", required = false) String condition,
                       @RequestParam(value = "deptId", required = false) String deptId) {
        Page<Map<String, Object>> list = this.deptService.list(condition, deptId);
        Page<Map<String, Object>> wrap = new DeptWrapper(list).wrap();
        return LayuiPageFactory.createPageInfo(wrap);
    }

    /**
     * 部门详情
     *
     */
    @RequestMapping(value = "/detail/{deptId}")
    @Permission
    @ResponseBody
    public Object detail(@PathVariable("deptId") Long deptId) {
        Dept dept = deptService.getById(deptId);
        DeptDto deptDto = new DeptDto();
        BeanUtil.copyProperties(dept, deptDto);
        deptDto.setPName(ConstantFactory.me().getDeptName(deptDto.getPid()));
        return deptDto;
    }

    /**
     * 修改部门
     *
     */
    @BussinessLog(value = "修改部门", key = "simpleName", dict = DeptDict.class)
    @RequestMapping(value = "/update")
    @Permission
    @ResponseBody
    public ResponseData update(Dept dept) {
        deptService.editDept(dept);
        return SUCCESS_TIP;
    }

    /**
     * 删除部门
     *
     */
    @BussinessLog(value = "删除部门", key = "deptId", dict = DeptDict.class)
    @RequestMapping(value = "/delete")
    @Permission
    @ResponseBody
    public ResponseData delete(@RequestParam Long deptId) {

        //缓存被删除的部门名称
        LogObjectHolder.me().set(ConstantFactory.me().getDeptName(deptId));

        deptService.deleteDept(deptId);

        return SUCCESS_TIP;
    }

}