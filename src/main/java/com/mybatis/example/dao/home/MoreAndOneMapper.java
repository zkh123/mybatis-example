package com.mybatis.example.dao.home;

import com.mybatis.example.entity.home.UserOne;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huanglijun on 2018/10/26.
 */
public interface MoreAndOneMapper {
    List<UserOne> getUser(@Param(value = "user_id") int userId);

}
