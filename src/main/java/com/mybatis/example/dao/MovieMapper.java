package com.mybatis.example.dao;

import com.mybatis.example.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by huanglijun on 2018/10/18.
 */
public interface MovieMapper {
    List<Movie> getList();

//    List<Map<String,Object>> getByDirectorT(@Param(value = "director")String director);

    List<Map<String,Object>> getByDirector(@Param(value = "director")String director);

    List<Movie> selectShowtime(@Param(value = "showtime")int showtime);

    List<Map<String,Object>> selectComposer(@Param(value = "composer")String composer);

    List<Movie> selectRate(@Param(value = "rate")float rate);

    List<Movie> selectById(@Param(value = "id")int id);

    List<Movie> selectByLanguage(@Param(value = "language")String language);

    List<Movie> selectComposerHandler(@Param(value = "composer")String composer);


}
