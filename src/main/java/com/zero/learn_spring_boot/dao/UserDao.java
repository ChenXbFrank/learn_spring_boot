package com.zero.learn_spring_boot.dao;

import com.zero.learn_spring_boot.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by 81046 on 2018-08-29
 */
@Repository
public class UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 1.定义一个sql语句
     * 2.定义一个RowMapper
     * 3.执行查询方法
     * @param name
     * @return
     */
    public User selectByName(String name){
        String sql="select * from user where name = ? ";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
        User user = jdbcTemplate.queryForObject(sql,new Object[]{name}, rowMapper);
        return user;
    }

}
