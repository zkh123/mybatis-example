package com.mybatis.example.entity;


import com.mybatis.example.utils.Sex;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * Created by huanglijun on 2018/10/19.
 */
@Alias("t_user")
public class User {

    private int id;
    private String name;
    private int age;
    private int testType;
    private Date testDate;
    private String role;
    private String sex;
    private String phone;
    private Date insertTime;
    private Date updateTime;
    private boolean isActive;

    public String getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex.getSexName();
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

    public int getTestType() {
        return testType;
    }

    public void setTestType(int testType) {
        this.testType = testType;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
