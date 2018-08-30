package com.zero.learn_spring_boot.repository;

import com.zero.learn_spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 81046 on 2018-08-29
 */
public interface UserRepository extends JpaRepository<User,Integer>{
}
