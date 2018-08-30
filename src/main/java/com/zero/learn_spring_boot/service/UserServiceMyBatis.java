package com.zero.learn_spring_boot.service;

import com.zero.learn_spring_boot.model.User;

import java.util.List;

/**
 * Created by 81046 on 2018-08-30
 */
public interface UserServiceMyBatis {
    /**
     * 查询所有的用户
     */
    List<User> findAllUser();

    /**
     * 查询Redis集群
     * @return
     */
//    String findRedis();
}
