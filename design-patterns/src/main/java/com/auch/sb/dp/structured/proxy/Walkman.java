package com.auch.sb.dp.structured.proxy;

import com.auch.sb.dp.structured.proxy.interceptor.Movie;

public interface Walkman {

    @Movie(pian = "我爱你 杀马特")
    void listenMusic(String album);
}
