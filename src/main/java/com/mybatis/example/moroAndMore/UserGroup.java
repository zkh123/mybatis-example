package com.mybatis.example.moroAndMore;

/**
 * 项目组 和 用户组 之间关系
 * Created by huanglijun on 2018/10/27.
 */
public class UserGroup {
    private int userId;
    private int groupId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
