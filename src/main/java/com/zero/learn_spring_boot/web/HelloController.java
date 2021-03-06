package com.zero.learn_spring_boot.web;

import com.zero.learn_spring_boot.model.User;
import com.zero.learn_spring_boot.service.UserService;
import com.zero.learn_spring_boot.service.UserServiceMyBatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by 81046 on 2018-08-29
 */
@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceMyBatis userServiceMyBatis;

    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Boot! 小石潭记1";
    }

    @GetMapping("/hello1")
    public String hello1(){
        return "Hello Spring Boot! 小石潭记2";
    }

    /**
     * springBoot 默认使用的json解析框架是Jackson
     * @return
     */
    @GetMapping("/getUser")
    public User getUser(){
        User user=new User();
        user.setAge(18);
        user.setId(1);
        user.setName("frank");
        user.setBirthDay(new Date());
        user.setRemarks("三好学生");
        return user;
    }

    @GetMapping("/save")
    public void save(){
        User user=new User();
        user.setAge(18);
        user.setName("小石潭记");
        user.setBirthDay(new Date());
        user.setRemarks("三好学生");
        userService.save(user);
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAll();
    }

    @GetMapping("/delete")
    public void delete(){
       userService.delete(1);
    }

    @GetMapping("/getUserByName")
    public User getUserByName(){
        return userService.findByName("frank");
    }

    @GetMapping("/findAllUser")
    public List<User> findAllUser(){
        return userServiceMyBatis.findAllUser();
    }

   /* @GetMapping("/findRedis")
    public String findRedis(){
        return userServiceMyBatis.findRedis();
    }*/

    @GetMapping("/helloHtml")
    public String helloHtml(ModelMap map){
        //返回值给页面
        map.addAttribute("name", "小石潭记");
        return "hello";
    }
}
