package com.auch.sb.dp.structured.proxy.interceptor;

import lombok.extern.java.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p></p>
 *
 * @author luohuiqi
 * @date 2023/4/13 11:18
 */
@Log
public class WalkProxyHandler implements InvocationHandler {


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 对象的所有Object类,直接通过
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        }
        Movie annotation = method.getAnnotation(Movie.class);
        log.info("不想听:" + args[0]+",想去看:"+annotation.pian()+"电影");
        return "";
    }


}

