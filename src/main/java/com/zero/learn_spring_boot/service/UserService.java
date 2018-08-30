package com.zero.learn_spring_boot.service;

import com.zero.learn_spring_boot.dao.UserDao;
import com.zero.learn_spring_boot.model.User;
import com.zero.learn_spring_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 81046 on 2018-08-29
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDao userDao;

    @Transactional
    public void save(User user){
        userRepository.save(user);
    }

    @Transactional
    public void delete(int id){
        userRepository.deleteById(id);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User findByName(String name){
        return userDao.selectByName(name);
    }
}
