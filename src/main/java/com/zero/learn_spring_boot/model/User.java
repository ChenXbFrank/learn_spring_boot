package com.zero.learn_spring_boot.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 1.使用@Entity进行实体类的持久化操作
 * 当JPA检测到我们的实体类当中有@Entity的注解的时候，
 * 会在数据库生成对应的表结构信息
 *
 * Created by 81046 on 2018-08-29
 */
@Entity
public class User {
    @Id //指定主键
    @GeneratedValue(strategy = GenerationType.AUTO) //主键自动增长
    private int id;
    private String name;
    private int age;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthDay;
    /**
     * 不想返回remarks
     * serialize:是否需要序列化属性
     */
    @JSONField(serialize = false )
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
