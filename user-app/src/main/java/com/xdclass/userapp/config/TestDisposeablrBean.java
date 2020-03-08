package com.xdclass.userapp.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * shoutDownHook 钩子
 *
 * @author 梁庆德
 * @date 2020年02月09日 12:17
 */
@Component
public class TestDisposeablrBean implements DisposableBean
{
    @Override public void destroy() throws Exception
    {
        System.out.println("DisposableBean 已经销毁，可以在销毁前做一些操作！");
    }
}
