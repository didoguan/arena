package com.deepspc.arena.modular.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

import static com.baomidou.mybatisplus.annotation.IdType.ID_WORKER;

/**
 * <p>
 * 角色和菜单关联表
 * </p>
 */
@TableName("sys_relation")
@KeySequence("SYS_RELATION_S")
@Data
public class Relation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "RELATION_ID", type = IdType.INPUT)
    private Long relationId;
    /**
     * 菜单id
     */
    @TableField(value="MENU_ID", el = "menuId, jdbcType=BIGINT")
    private Long menuId;
    /**
     * 角色id
     */
    @TableField(value="ROLE_ID", el = "roleId, jdbcType=BIGINT")
    private Long roleId;

    @Override
    public String toString() {
        return "Relation{" +
                ", relationId=" + relationId +
                ", menuId=" + menuId +
                ", roleId=" + roleId +
                "}";
    }
}
