package com.buba.de.utils;

import redis.clients.jedis.Jedis;

public class Redis {

    private Jedis jedis;

    public void setJedis() {
        //连接redis服务器(在这里是连接本地的)
        jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("连接服务成功");
    }

    public Jedis getJedis() {
        return jedis;
    }
}
