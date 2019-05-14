package com.deepspc.arena.core.beetl;

import com.deepspc.arena.config.properties.AppNameProperties;
import com.deepspc.arena.core.shiro.ShiroExt;
import com.deepspc.arena.utils.ToolUtil;
import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.io.UnsupportedEncodingException;

/**
 * beetl拓展配置,绑定一些工具类,方便在模板中直接调用
 *
 */
public class BeetlConfiguration extends BeetlGroupUtilConfiguration {

    @Autowired
    Environment env;
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    AppNameProperties appNameProperties;

    @Override
    public void initOther() {
        groupTemplate.registerFunctionPackage("tool", new ToolUtil());
        groupTemplate.registerFunctionPackage("shiro", new ShiroExt());
        groupTemplate.registerFunctionPackage("systemName", appNameProperties.getName());

        groupTemplate.registerFunction("env", new Function() {
            @Override
            public String call(Object[] paras, Context ctx) {
                String key = (String)paras[0];
                String value =  env.getProperty(key);
                if(value!=null) {
                    return getStr(value);
                }
                if(paras.length==2) {
                    return (String)paras[1];
                }
                return null;
            }

            protected String getStr(String str) {
                try {
                    return new String(str.getBytes("iso8859-1"),"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
