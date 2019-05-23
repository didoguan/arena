package com.deepspc.arena.modular.system.service;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.deepspc.arena.core.exception.CoreExceptionEnum;
import com.deepspc.arena.core.exception.ServiceException;
import com.deepspc.arena.core.shiro.ShiroKit;
import com.deepspc.arena.core.shiro.ShiroUser;
import com.deepspc.arena.modular.system.entity.FileInfo;
import com.deepspc.arena.modular.system.entity.User;
import com.deepspc.arena.modular.system.mapper.FileInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 文件信息表
 * 服务实现类
 * </p>
 *
 */
@Service
public class FileInfoService extends ServiceImpl<FileInfoMapper, FileInfo> {

    @Autowired
    private UserService userService;

    /**
     * 上传头像
     *
     */
    @Transactional(rollbackFor = Exception.class)
    public void uploadAvatar(String avatar) {
        ShiroUser currentUser = ShiroKit.getUser();
        if (currentUser == null) {
            throw new ServiceException(CoreExceptionEnum.NO_CURRENT_USER.getCode(),
                    CoreExceptionEnum.NO_CURRENT_USER.getMessage());
        }

        User user = userService.getById(currentUser.getId());

        //保存文件信息
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileId(IdWorker.getIdStr());
        fileInfo.setFileData(avatar);
        fileInfo.setCreateTime(new Date());
        this.save(fileInfo);

        //更新用户的头像
        user.setAvatar(fileInfo.getFileId());
        userService.updateById(user);
    }
}
