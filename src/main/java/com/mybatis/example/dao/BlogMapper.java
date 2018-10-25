package com.mybatis.example.dao;

import com.mybatis.example.complexResultMap.Blog;
import org.apache.ibatis.annotations.Param;

public interface BlogMapper {
    Blog findById(@Param(value = "id") int id);
}
