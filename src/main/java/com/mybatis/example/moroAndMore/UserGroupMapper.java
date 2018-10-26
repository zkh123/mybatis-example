package com.mybatis.example.moroAndMore;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGroupMapper {
    List<User> getUsersByGroupId(@Param(value = "groupId") int id);

    List<Group> getGroupsByUserId(@Param(value = "userId") int id);
}