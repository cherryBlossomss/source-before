package com.auch.sb.dp.structured.proxy;

import com.auch.sb.dp.structured.proxy.interceptor.WalkProxyHandler;

import java.lang.reflect.Proxy;

/**
 * <p></p>
 *
 * @author luohuiqi
 * @date 2023/5/16 15:15
 */
public class Test {

//    static {
//        //JDK1.8及以前的版本
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        //JDK1.8以后的版本
//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
//    }

    public static void main(String[] args) {
//        // 静态代理
//        UserStaticProxy userStaticProxy = new UserStaticProxy(new User("jack"));
//        userStaticProxy.listenMusic("Machine Head");
//       // 动态代理-调用原方法
//        Walkman walkman = (Walkman) Proxy.newProxyInstance(Walkman.class.getClassLoader(), new Class[]{Walkman.class}, new UserDynamicProxyHandlaer(new User("Alice")));
//        walkman.listenMusic("FireBall");
        // 动态代理 - 不调用原方法
//        Walkman walkman001 = (Walkman) Proxy.newProxyInstance(Walkman.class.getClassLoader(), new Class[]{Walkman.class}, new WalkProxyHandler());
//        walkman001.listenMusic("Burn");

        User user = (User) CglibProxyFactory.getProxy(User.class);
        user.listenMusic("The House of Blue Light");

    }
}
