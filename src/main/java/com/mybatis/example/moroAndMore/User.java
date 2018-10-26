package com.mybatis.example.moroAndMore;

import java.util.List;

/**
 * 用户
 * 一个用户可以在很多个项目组
 * Created by huanglijun on 2018/10/27.
 */
public class User {
    private int id;
    private String username;
    private String mobile;
    private List<Group> groups;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}