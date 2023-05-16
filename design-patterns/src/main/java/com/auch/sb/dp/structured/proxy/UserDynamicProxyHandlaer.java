package com.auch.sb.dp.structured.proxy;

import lombok.extern.java.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p></p>
 *
 * @author luohuiqi
 * @date 2023/5/16 15:20
 */
@Log
public class UserDynamicProxyHandlaer implements InvocationHandler {

    private final User user;

    public UserDynamicProxyHandlaer(User user) {
        this.user = user;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info(user.getName() + "晚饭后，准备听歌");
        method.invoke(user, args);
        log.info(user.getName() + "听完歌后准备去洗澡");
        return null;
    }
}
