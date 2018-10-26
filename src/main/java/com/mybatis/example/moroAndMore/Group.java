package com.mybatis.example.moroAndMore;

import java.util.List;

/**
 * 项目
 * 一个项目组 可以包含很多用户
 * Created by huanglijun on 2018/10/27.
 */
public class Group {
    private int groupId;
    private String groupName;
    private List<User> users;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
