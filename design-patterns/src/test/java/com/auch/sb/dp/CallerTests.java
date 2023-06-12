package com.auch.sb.dp;


import com.auch.sb.dp.caller.CallBackInterface;
import com.auch.sb.dp.caller.Employee;
import com.auch.sb.dp.structured.proxy.Walkman;
import com.auch.sb.dp.structured.proxy.interceptor.WalkProxyHandler;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

class CallerTests {


	@Test
	void call() {
		new Employee().doSome(() -> System.out.println("所有都已干完，终于可以休息了"));
	}

}
