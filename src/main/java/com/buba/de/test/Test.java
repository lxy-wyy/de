package com.buba.de.test;

import com.buba.de.pojo.Limits;
import redis.clients.jedis.Jedis;

public class Test {
    private Jedis jedis;

    public static void main(String[] args) {
        Test test = new Test();
        test.setJedis();
        test.testString();
    }


    public void setJedis() {
        //连接redis服务器(在这里是连接本地的)
        jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("连接服务成功");
    }

    public void testString() {
        Limits limits=new Limits();
        limits.setName("1111");
        limits.setPid(11);
        limits.setHref("http://localhost:8083/jsp/zTree.jsp");
        limits.setId(1);


        jedis.set("name", String.valueOf(limits));
       // jedis.append("name", " is my name;");
      //  jedis.del("name");
        //jedis.mset("name", "xgy", "age", "19", "email", "xgy@outlook.com");
       // jedis.incr("age");
        System.out.println(jedis.get("name") + " " + jedis.get("age") + " " + jedis.get("email"));
    }
}
