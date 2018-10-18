package com.mybatis.example.errorTitle;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.example.entity.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huanglijun on 2018/10/18.
 */
public class ToJson {

    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        Movie movie1 = new Movie();
        movie1.setId(100);
        movie1.setRate(7.0f);
        movie1.setDirector("尔冬升");
        movie1.setUrl("http://www.baidu.com");

        Movie movie2 = new Movie();
        movie2.setId(100);
        movie2.setRate(7.0f);
        movie2.setDirector("尔冬升");
        movie2.setUrl("http://www.baidu.com");

        List<Movie> list = new ArrayList<>();
        list.add(movie1);
        list.add(movie2);
        System.out.println(JSONObject.toJSONString(list));


    }
}
