package com.auch.sb.dp.structured.proxy;

import lombok.extern.java.Log;

/**
 * <p></p>
 *
 * @author luohuiqi
 * @date 2023/5/16 14:58
 */
@Log
public class User implements Walkman {

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public void listenMusic(String album) {
        log.info(name+"在听:" + album);
    }

    public String getName() {
        return name;
    }
}
