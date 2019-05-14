package com.deepspc.arena.modular.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 登录记录
 * </p>
 *
 */
@TableName("sys_login_log")
@KeySequence("SYS_LOGIN_LOG_S")
@Data
public class LoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "LOGIN_LOG_ID", type = IdType.INPUT)
    private Long loginLogId;
    /**
     * 日志名称
     */
    @TableField("LOG_NAME")
    private String logName;
    /**
     * 管理员id
     */
    @TableField(value="USER_ID", el = "userId, jdbcType=BIGINT")
    private Long userId;
    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 是否执行成功
     */
    @TableField("SUCCEED")
    private String succeed;
    /**
     * 具体消息
     */
    @TableField("MESSAGE")
    private String message;
    /**
     * 登录ip
     */
    @TableField("IP_ADDRESS")
    private String ipAddress;

    @Override
    public String toString() {
        return "LoginLog{" +
                ", loginLogId=" + loginLogId +
                ", logName=" + logName +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", succeed=" + succeed +
                ", message=" + message +
                ", ipAddress=" + ipAddress +
                "}";
    }
}
