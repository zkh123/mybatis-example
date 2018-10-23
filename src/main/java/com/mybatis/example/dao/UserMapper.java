package com.mybatis.example.dao;

import com.mybatis.example.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huanglijun on 2018/10/19.
 */
public interface UserMapper {

    User selectUserById(@Param(value = "id")int id);

    List<User> selectUser();

    User selectUserByIdTow(@Param(value = "id")int id);
}
