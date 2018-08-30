package com.zero.learn_spring_boot.service.impl;

import com.zero.learn_spring_boot.mapper.UserMapper;
import com.zero.learn_spring_boot.model.User;
import com.zero.learn_spring_boot.service.UserServiceMyBatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.List;

/**
 * Created by 81046 on 2018-08-30
 */
@Service
public class UserServiceMyBatisImpl implements UserServiceMyBatis{

    @Autowired
    private UserMapper userMapper;

    /*@Autowired
    private JedisCluster jedisCluster;

    @Override
    public String findRedis(){
        jedisCluster.set("username","倚天屠龙记");
        return jedisCluster.get("username");
    }*/

    @Override
    //哇，就这一步就实现了Redis的缓存  需要在启动类里面添加缓存注解
    @Cacheable(value = "findAllUser")
    public List<User> findAllUser() {
        System.out.println("如果第二次没有打印该语句，说明走了缓存，没有执行该方法！");
        return userMapper.findAllUser();
    }

}
