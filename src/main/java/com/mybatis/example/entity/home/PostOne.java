package com.mybatis.example.entity.home;

import java.io.Serializable;

/**
 * Created by huanglijun on 2018/10/26.
 */
public class PostOne implements Serializable{
    private int id;
    private UserOne userOne;
    private String title;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserOne getUserOne() {
        return userOne;
    }

    public void setUserOne(UserOne userOne) {
        this.userOne = userOne;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
