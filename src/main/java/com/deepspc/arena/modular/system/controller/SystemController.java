package com.deepspc.arena.modular.system.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollectionUtil;
import com.deepspc.arena.core.common.constant.DefaultAvatar;
import com.deepspc.arena.core.common.constant.factory.ConstantFactory;
import com.deepspc.arena.core.exception.BizExceptionEnum;
import com.deepspc.arena.core.exception.CoreExceptionEnum;
import com.deepspc.arena.core.exception.ServiceException;
import com.deepspc.arena.core.log.LogObjectHolder;
import com.deepspc.arena.core.reqres.response.ResponseData;
import com.deepspc.arena.core.shiro.ShiroKit;
import com.deepspc.arena.core.shiro.ShiroUser;
import com.deepspc.arena.modular.base.controller.BaseController;
import com.deepspc.arena.modular.system.entity.FileInfo;
import com.deepspc.arena.modular.system.entity.User;
import com.deepspc.arena.modular.system.factory.UserFactory;
import com.deepspc.arena.modular.system.service.FileInfoService;
import com.deepspc.arena.modular.system.service.UserService;
import com.deepspc.arena.utils.ToolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用控制器
 *
 */
@Controller
@RequestMapping("/system")
@Slf4j
public class SystemController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private FileInfoService fileInfoService;

    /**
     * 主页面
     *
     */
    @RequestMapping("/welcome")
    public String console() {
        return "/modular/frame/welcome.html";
    }

    /**
     * 主题页面
     *
     */
    @RequestMapping("/theme")
    public String theme() {
        return "/modular/frame/theme.html";
    }

    /**
     * 跳转到修改密码界面
     *
     */
    @RequestMapping("/user_chpwd")
    public String chPwd() {
        return "/modular/frame/password.html";
    }

    /**
     * 个人消息列表
     *
     */
    @RequestMapping("/message")
    public String message() {
        return "/modular/frame/message.html";
    }

    /**
     * 跳转到查看用户详情页面
     *
     */
    @RequestMapping("/user_info")
    public String userInfo(Model model) {
        Long userId = ShiroKit.getUserNotNull().getId();
        User user = this.userService.getById(userId);

        model.addAllAttributes(BeanUtil.beanToMap(user));
        model.addAttribute("roleName", ConstantFactory.me().getRoleName(user.getRoleId()));
        model.addAttribute("deptName", ConstantFactory.me().getDeptName(user.getDeptId()));
        LogObjectHolder.me().set(user);
        return "/modular/frame/user_info.html";
    }

    /**
     * 通用的树列表选择器
     *
     */
    @RequestMapping("/commonTree")
    public String deptTreeList(@RequestParam("formName") String formName,
                               @RequestParam("formId") String formId,
                               @RequestParam("treeUrl") String treeUrl, Model model) {

        if (ToolUtil.isOneEmpty(formName, formId, treeUrl)) {
            throw new ServiceException(BizExceptionEnum.FIELD_UNAVAIL.getCode(),
                                        BizExceptionEnum.FIELD_UNAVAIL.getMessage());
        }

        try {
            model.addAttribute("formName", URLDecoder.decode(formName, "UTF-8"));
            model.addAttribute("formId", URLDecoder.decode(formId, "UTF-8"));
            model.addAttribute("treeUrl", URLDecoder.decode(treeUrl, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new ServiceException(BizExceptionEnum.FIELD_UNAVAIL.getCode(),
                                        BizExceptionEnum.FIELD_UNAVAIL.getMessage());
        }

        return "/common/tree_dlg.html";
    }

    /**
     * 上传头像
     *
     */
    @RequestMapping("/uploadAvatar")
    @ResponseBody
    public Object uploadAvatar(@RequestParam String avatar) {

        if (ToolUtil.isEmpty(avatar)) {
            throw new ServiceException("请求头像为空");
        }

        avatar = avatar.substring(avatar.indexOf(",") + 1);

        fileInfoService.uploadAvatar(avatar);

        return SUCCESS_TIP;
    }

    /**
     * 预览头像
     *
     */
    @RequestMapping("/previewAvatar")
    @ResponseBody
    public Object previewAvatar(HttpServletResponse response) {

        ShiroUser currentUser = ShiroKit.getUser();
        if (currentUser == null) {
            throw new ServiceException(CoreExceptionEnum.NO_CURRENT_USER.getCode(),
                                        CoreExceptionEnum.NO_CURRENT_USER.getMessage());
        }

        //获取当前用户的头像id
        User user = userService.getById(currentUser.getId());
        String avatar = user.getAvatar();

        //如果头像id为空就返回默认的
        if (ToolUtil.isEmpty(avatar)) {
            avatar = DefaultAvatar.BASE_64_AVATAR;
        } else {
            FileInfo fileInfo = fileInfoService.getById(avatar);
            if (fileInfo == null) {
                avatar = DefaultAvatar.BASE_64_AVATAR;
            } else {
                avatar = fileInfo.getFileData();
            }
        }

        //输出图片的文件流
        try {
            response.setContentType("image/jpeg");
            byte[] decode = Base64.decode(avatar);
            response.getOutputStream().write(decode);
        } catch (IOException e) {
            log.error("获取图片的流错误！", avatar);
            throw new ServiceException(CoreExceptionEnum.SERVICE_ERROR.getCode(),
                                        CoreExceptionEnum.SERVICE_ERROR.getMessage());
        }

        return null;
    }

    /**
     * 获取当前用户详情
     *
     */
    @RequestMapping("/currentUserInfo")
    @ResponseBody
    public ResponseData getUserInfo() {

        ShiroUser currentUser = ShiroKit.getUser();
        if (currentUser == null) {
            throw new ServiceException(CoreExceptionEnum.NO_CURRENT_USER.getCode(),
                                        CoreExceptionEnum.NO_CURRENT_USER.getMessage());
        }

        User user = userService.getById(currentUser.getId());
        Map<String, Object> map = UserFactory.removeUnSafeFields(user);

        HashMap<Object, Object> hashMap = CollectionUtil.newHashMap();
        hashMap.putAll(map);
        hashMap.put("roleName", ConstantFactory.me().getRoleName(user.getRoleId()));
        hashMap.put("deptName", ConstantFactory.me().getDeptName(user.getDeptId()));

        return ResponseData.success(hashMap);
    }

}
