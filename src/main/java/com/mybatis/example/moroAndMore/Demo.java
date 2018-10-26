package com.mybatis.example.moroAndMore;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by huanglijun on 2018/10/27.
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        test1();
    }

    private static void test1() throws IOException {
        /**
         * 加载相对路径
         */
        String resource = "moroAndMore/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        UserGroupMapper userGroupMapper = sqlSession.getMapper(UserGroupMapper.class);
        //第三步：接口调用方法执行sql

        List<User> list1 = userGroupMapper.getUsersByGroupId(1);
        System.out.println(JSONObject.toJSONString(list1));
        List<Group> list2 = userGroupMapper.getGroupsByUserId(1);
        System.out.println(JSONObject.toJSONString(list2));
        sqlSession.close();
    }
}
