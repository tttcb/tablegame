package com.tablegame.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Component
public class RedisServer {

    @Autowired
    public RedisTemplate redisTemplate;

    public <T> void setCacheObject(final String key, final T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public <T> void setCacheObject(final String key, final T value, final Long timeout, final TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public <T> void expire(final String key, final Long timeout, final TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }

    public <T> void expire(final String key, final Long timeout) {
        this.expire(key, timeout, TimeUnit.SECONDS);
    }

    public <T> Long getExpire(final String key) {
        return redisTemplate.getExpire(key);
    }

    public Boolean hasKey(final String key) {
        return redisTemplate.hasKey(key);
    }

    public <T> T getValue(final String key) {
        ValueOperations<String, T> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    public <T> Boolean delete(final String key){
        return redisTemplate.delete(key);
    }

}
