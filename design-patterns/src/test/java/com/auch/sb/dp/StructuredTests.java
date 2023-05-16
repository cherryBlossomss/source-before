package com.auch.sb.dp;


import com.auch.sb.dp.structured.proxy.Walkman;
import com.auch.sb.dp.structured.proxy.interceptor.WalkProxyHandler;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

class StructuredTests {


	@Test
	void contextLoads() {
		//        // 静态代理
//        UserStaticProxy userStaticProxy = new UserStaticProxy(new User("jack"));
//        userStaticProxy.listenMusic("Machine Head");
//       // 动态代理-调用原方法
//        Walkman walkman = (Walkman) Proxy.newProxyInstance(Walkman.class.getClassLoader(), new Class[]{Walkman.class}, new UserDynamicProxyHandlaer(new User("Alice")));
//        walkman.listenMusic("FireBall");
		// 动态代理 - 不调用原方法
		Walkman walkman001 = (Walkman) Proxy.newProxyInstance(Walkman.class.getClassLoader(), new Class[]{Walkman.class}, new WalkProxyHandler());
		walkman001.listenMusic("Burn");

	}

}
