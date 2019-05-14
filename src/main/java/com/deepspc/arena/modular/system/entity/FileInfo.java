package com.deepspc.arena.modular.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 文件信息表
 *
 * </p>
 *
 */
@TableName("sys_file_info")
@KeySequence("SYS_FILE_INFO_S")
@Data
public class FileInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "FILE_ID", type = IdType.INPUT)
    private String fileId;
    /**
     * base64编码的文件
     */
    @TableField("FILE_DATA")
    private String fileData;
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
    @TableField(value = "CREATE_USER", el = "createUser, jdbcType=BIGINT", fill = FieldFill.INSERT)
    private Long createUser;
    /**
     * 修改用户
     */
    @TableField(value = "UPDATE_USER", el = "updateUser, jdbcType=BIGINT", fill = FieldFill.UPDATE)
    private Long updateUser;

    @Override
    public String toString() {
        return "FileInfo{" +
                ", fileId=" + fileId +
                ", fileData=" + fileData +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createUser=" + createUser +
                ", updateUser=" + updateUser +
                "}";
    }
}
