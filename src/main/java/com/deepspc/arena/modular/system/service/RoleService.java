package com.deepspc.arena.modular.system.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepspc.arena.core.common.constant.Const;
import com.deepspc.arena.core.common.constant.cache.Cache;
import com.deepspc.arena.core.common.constant.factory.ConstantFactory;
import com.deepspc.arena.core.common.node.ZTreeNode;
import com.deepspc.arena.core.common.page.LayuiPageFactory;
import com.deepspc.arena.core.exception.BizExceptionEnum;
import com.deepspc.arena.core.exception.ServiceException;
import com.deepspc.arena.core.log.LogObjectHolder;
import com.deepspc.arena.modular.system.entity.Relation;
import com.deepspc.arena.modular.system.entity.Role;
import com.deepspc.arena.modular.system.mapper.RelationMapper;
import com.deepspc.arena.modular.system.mapper.RoleMapper;
import com.deepspc.arena.modular.system.model.RoleDto;
import com.deepspc.arena.utils.CacheUtil;
import com.deepspc.arena.utils.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 */
@Service
public class RoleService extends ServiceImpl<RoleMapper, Role> {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RelationMapper relationMapper;

    @Resource
    private UserService userService;

    /**
     * 添加角色
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public void addRole(Role role) {
        if (ToolUtil.isOneEmpty(role, role.getName(), role.getPid(), role.getDescription())) {
            throw new ServiceException(BizExceptionEnum.FIELD_UNAVAIL.getCode(),
                                            BizExceptionEnum.FIELD_UNAVAIL.getMessage());
        }
        role.setCreateTime(new Date());
        role.setRoleId(null);

        this.save(role);
    }

    /**
     * 编辑角色
     */
    @Transactional(rollbackFor = Exception.class)
    public void editRole(RoleDto roleDto) {

        if (ToolUtil.isOneEmpty(roleDto, roleDto.getName(), roleDto.getPid(), roleDto.getDescription())) {
            throw new ServiceException(BizExceptionEnum.FIELD_UNAVAIL.getCode(),
                    BizExceptionEnum.FIELD_UNAVAIL.getMessage());
        }

        Role old = this.getById(roleDto.getRoleId());
        BeanUtil.copyProperties(roleDto, old);
        old.setUpdateTime(new Date());
        this.updateById(old);

        //删除缓存
        CacheUtil.removeAll(Cache.CONSTANT);
    }

    /**
     * 设置某个角色的权限
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public void setAuthority(Long roleId, String ids) {

        // 删除该角色所有的权限
        this.roleMapper.deleteRolesById(roleId);

        // 添加新的权限
        for (Long id : Convert.toLongArray(ids.split(","))) {
            Relation relation = new Relation();
            relation.setRoleId(roleId);
            relation.setMenuId(id);
            this.relationMapper.insert(relation);
        }

        // 刷新当前用户的权限
        userService.refreshCurrentUser();
    }

    /**
     * 删除角色
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public void delRoleById(Long roleId) {

        if (ToolUtil.isEmpty(roleId)) {
            throw new ServiceException(BizExceptionEnum.FIELD_UNAVAIL.getCode(),
                                            BizExceptionEnum.FIELD_UNAVAIL.getMessage());
        }

        //不能删除超级管理员角色
        if (roleId.equals(Const.ADMIN_ROLE_ID)) {
            throw new ServiceException(BizExceptionEnum.CANT_DELETE_ADMIN.getCode(),
                                            BizExceptionEnum.CANT_DELETE_ADMIN.getMessage());
        }

        //缓存被删除的角色名称
        LogObjectHolder.me().set(ConstantFactory.me().getSingleRoleName(roleId));

        //删除角色
        this.roleMapper.deleteById(roleId);

        //删除该角色所有的权限
        this.roleMapper.deleteRolesById(roleId);

        //删除缓存
        CacheUtil.removeAll(Cache.CONSTANT);
    }

    /**
     * 根据条件查询角色列表
     *
     */
    public Page<Map<String, Object>> selectRoles(String condition) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.selectRoles(page, condition);
    }

    /**
     * 删除某个角色的所有权限
     *
     */
    public int deleteRolesById(Long roleId) {
        return this.baseMapper.deleteRolesById(roleId);
    }

    /**
     * 获取角色列表树
     *
     */
    public List<ZTreeNode> roleTreeList() {
        return this.baseMapper.roleTreeList();
    }

    /**
     * 获取角色列表树
     *
     */
    public List<ZTreeNode> roleTreeListByRoleId(String[] roleId) {
        return this.baseMapper.roleTreeListByRoleId(roleId);
    }

}
