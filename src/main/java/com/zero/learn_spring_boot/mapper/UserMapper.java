package com.zero.learn_spring_boot.mapper;

import com.zero.learn_spring_boot.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 81046 on 2018-08-30
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有的用户
     */
    List<User> findAllUser();
}
