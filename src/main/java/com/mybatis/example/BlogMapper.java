package com.mybatis.example;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BlogMapper {

    List<Blog> selectBlog(@Param(value = "id") Integer id);

    @Select("SELECT * FROM Blog WHERE username = #{username}")
    List<Blog> selectByUsername(@Param(value = "username") String username);
}
