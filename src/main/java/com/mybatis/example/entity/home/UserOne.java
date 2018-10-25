package com.mybatis.example.entity.home;

import java.io.Serializable;
import java.util.List;

/**
 * Created by huanglijun on 2018/10/26.
 */
public class UserOne implements Serializable{

    private int id;
    private String username;
    private String mobile;
    private List<PostOne> posts;

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

    public List<PostOne> getPosts() {
        return posts;
    }

    public void setPosts(List<PostOne> posts) {
        this.posts = posts;
    }
}
