package com.auch.sb.dp.structured.proxy.interceptor;

import java.lang.annotation.*;

@Documented
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Movie {

    String pian();
}
