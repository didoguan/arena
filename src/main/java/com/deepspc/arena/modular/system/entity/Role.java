package com.deepspc.arena.modular.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 角色表
 * </p>
 */
@TableName("sys_role")
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 3296574873443999757L;
    /**
     * 主键id
     */
    @TableId(value = "ROLE_ID", type = IdType.ID_WORKER)
    private Long roleId;
    /**
     * 父角色id
     */
    @TableField("PID")
    private Long pid;
    /**
     * 角色名称
     */
    @TableField("NAME")
    private String name;
    /**
     * 角色编码
     */
    @TableField("ROLE_CODE")
    private String roleCode;
    /**
     * 角色描述
     */
    @TableField("DESCRIPTION")
    private String description;
    /**
     * 序号
     */
    @TableField("SORT")
    private Integer sort;
    /**
     * 乐观锁
     */
    @TableField("VERSION")
    private Integer version;
    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField(value = "UPDATE_TIME", fill = FieldFill.UPDATE)
    private Date updateTime;
    /**
     * 创建用户
     */
    @TableField(value = "CREATE_USER", fill = FieldFill.INSERT)
    private Long createUser;
    /**
     * 修改用户
     */
    @TableField(value = "UPDATE_USER", fill = FieldFill.UPDATE)
    private Long updateUser;

    @Override
    public String toString() {
        return "Role{" +
                ", roleId=" + roleId +
                ", pid=" + pid +
                ", name=" + name +
                ", roleCode=" + roleCode +
                ", description=" + description +
                ", sort=" + sort +
                ", version=" + version +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createUser=" + createUser +
                ", updateUser=" + updateUser +
                "}";
    }
}
