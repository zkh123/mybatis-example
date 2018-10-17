package com.mybatis.example;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogMapper {

    List<Blog> selectBlog(@Param(value = "id") Integer id);
}
