package com.deepspc.arena.core.common.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.deepspc.arena.utils.HttpContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Layui Table默认的分页参数创建
 */
public class LayuiPageFactory {

    /**
     * 获取layui table的分页参数
     *
     * @author fengshuonan
     * @Date 2019/1/25 22:13
     */
    public static Page defaultPage() {
        HttpServletRequest request = HttpContext.getRequest();

        //每页多少条数据
        int limit = Integer.valueOf(request.getParameter("limit"));

        //第几页
        int page = Integer.valueOf(request.getParameter("page"));

        return new Page(page, limit);
    }

    /**
     * 创建layui能识别的分页响应参数
     *
     * @author fengshuonan
     * @Date 2019/1/25 22:14
     */
    public static LayuiPageInfo createPageInfo(IPage page) {
        LayuiPageInfo result = new LayuiPageInfo();
        result.setCount(page.getTotal());
        result.setData(page.getRecords());
        return result;
    }
}
