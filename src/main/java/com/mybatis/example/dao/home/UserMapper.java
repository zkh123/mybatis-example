package com.mybatis.example.dao.home;

import com.mybatis.example.entity.home.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huanglijun on 2018/10/26.
 */
public interface UserMapper {
    User GetUserByID(@Param(value = "id")int id);

    List<User> getUserList();

    Integer insertUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(int userId);

    User getUser(int id);

}
