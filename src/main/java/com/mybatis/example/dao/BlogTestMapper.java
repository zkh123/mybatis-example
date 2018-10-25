package com.mybatis.example.dao;

import com.mybatis.example.entity.BlogTest;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BlogTestMapper {

    List<BlogTest> selectBlog(@Param(value = "id") Integer id);

    @Select("SELECT * FROM BlogTest WHERE username = #{username}")
    List<BlogTest> selectByUsername(@Param(value = "username") String username);
}
