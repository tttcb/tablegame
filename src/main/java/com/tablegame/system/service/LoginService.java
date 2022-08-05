package com.tablegame.system.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author tu.cb
 */
@Service
public class LoginService {

    @Autowired
    public RedisServer redisServer;

    @SneakyThrows
    public String login(String username, String password) {
        Boolean result = false;
        //数据库校验

        if(result){
            throw new Exception("Login failed");
        }
        return null;
    }

    public String createToken() {
        String token = UUID.randomUUID().toString();

        return null;
    }
}
