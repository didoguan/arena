package com.deepspc.arena.modular.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 操作日志
 * </p>
 */
@TableName("sys_operation_log")
@KeySequence("SYS_OPERATION_LOG_S")
@Data
public class OperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "OPERATION_LOG_ID", type = IdType.INPUT)
    private Long operationLogId;
    /**
     * 日志类型(字典)
     */
    @TableField("LOG_TYPE")
    private String logType;
    /**
     * 日志名称
     */
    @TableField("LOG_NAME")
    private String logName;
    /**
     * 用户id
     */
    @TableField(value="USER_ID", el = "userId, jdbcType=BIGINT")
    private Long userId;
    /**
     * 类名称
     */
    @TableField("CLASS_NAME")
    private String className;
    /**
     * 方法名称
     */
    @TableField("METHOD")
    private String method;
    /**
     * 创建时间
     */
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 是否成功(字典)
     */
    @TableField("SUCCEED")
    private String succeed;
    /**
     * 备注
     */
    @TableField("MESSAGE")
    private String message;

    @Override
    public String toString() {
        return "OperationLog{" +
                ", operationLogId=" + operationLogId +
                ", logType=" + logType +
                ", logName=" + logName +
                ", userId=" + userId +
                ", className=" + className +
                ", method=" + method +
                ", createTime=" + createTime +
                ", succeed=" + succeed +
                ", message=" + message +
                "}";
    }
}
