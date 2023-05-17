package com.auch.sb.dp.structured.proxy;


import net.sf.cglib.proxy.Enhancer;

/**
 * <p>CGLib实现非接口代理</p>
 *
 * @author luohuiqi
 * @date 2023/4/13 10:29
 */
public class CglibProxyFactory {

    public static Object  getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}
