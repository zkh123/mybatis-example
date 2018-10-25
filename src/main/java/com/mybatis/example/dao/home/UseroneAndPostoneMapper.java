package com.mybatis.example.dao.home;

import com.mybatis.example.entity.home.PostOne;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huanglijun on 2018/10/26.
 */
public interface UseroneAndPostoneMapper {
    List<PostOne> selectMoreAndOne(@Param(value = "id")int postId);

}
