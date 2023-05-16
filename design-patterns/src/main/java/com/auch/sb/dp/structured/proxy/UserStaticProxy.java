package com.auch.sb.dp.structured.proxy;

import lombok.extern.java.Log;

/**
 * <p></p>
 *
 * @author luohuiqi
 * @date 2023/5/16 14:58
 */
@Log
public class UserStaticProxy implements Walkman {

    private User user;

    public UserStaticProxy(User user) {
        this.user = user;
    }

    @Override
    public void listenMusic(String album) {
        // 代理前增强
        log.info(user.getName() + "晚饭后，准备听歌");
        user.listenMusic(album);
        // 代理后增强
        log.info(user.getName() + "听完歌后准备去洗澡");
    }
}
