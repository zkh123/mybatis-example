package com.mybatis.example;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.example.dao.home.UserMapper;
import com.mybatis.example.dao.home.UseroneAndPostoneMapper;
import com.mybatis.example.entity.home.PostOne;
import com.mybatis.example.entity.home.User;
import com.mybatis.example.entity.home.UserOne;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Created by huanglijun on 2018/10/26.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
//        test17();

//        test18();
//        test19();
//        test20();
//        test21();
//        test22();
        test23();
    }

    /**
     * 根据id查询
     * @throws Exception
     */
    public static void test17() throws Exception{
        /**
         * 加载相对路径
         */
        String resource = "config/Configure.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //第三步：接口调用方法执行sql

        User user = userMapper.GetUserByID(1);
        sqlSession.close();
        System.out.println(JSONObject.toJSONString(user));
    }

    /**
     * 根据id查询
     * @throws Exception
     */
    public static void test18() throws Exception{
        /**
         * 加载相对路径
         */
        String resource = "config/Configure.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //第三步：接口调用方法执行sql

        User user = userMapper.getUser(1);
        sqlSession.close();
        System.out.println(JSONObject.toJSONString(user));
    }

    /**
     * 添加数据
     * @throws Exception
     */
    public static void test19() throws Exception{
        /**
         * 加载相对路径
         */
        String resource = "config/Configure.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //第三步：接口调用方法执行sql
        // 执行插入
        User user = new User();
//        user.setId(0);
        user.setName("Google");
        user.setDept("Tech");
        user.setWebsite("http://www.google.com");
        user.setPhone("120");

        Integer size = userMapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(size);
    }

    /**
     * 获取列表
     * @throws Exception
     */
    public static void test20() throws Exception{
        /**
         * 加载相对路径
         */
        String resource = "config/Configure.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //第三步：接口调用方法执行sql

        List<User> list = userMapper.getUserList();
        sqlSession.close();
        System.out.println(JSONObject.toJSONString(list));
    }

    /**
     * 更新
     * @throws Exception
     */
    public static void test21() throws Exception{
        /**
         * 加载相对路径
         */
        String resource = "config/Configure.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //第三步：接口调用方法执行sql

        User user = new User();
        user.setId(2);
        user.setName("New name");

        Integer size = userMapper.updateUser(user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(size);
    }

    /**
     * 根据id删除
     * @throws Exception
     */
    public static void test22() throws Exception{
        /**
         * 加载相对路径
         */
        String resource = "config/Configure.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //第三步：接口调用方法执行sql

        Integer size = userMapper.deleteUser(2);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(size);
    }

    /**
     * 一对多联合查询
     * @throws Exception
     */
    public static void test23() throws Exception{
        /**
         * 加载相对路径
         */
        String resource = "config/Configure_more_one.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        UseroneAndPostoneMapper useroneAndPostoneMapper = sqlSession.getMapper(UseroneAndPostoneMapper.class);
        //第三步：接口调用方法执行sql

        List<PostOne> list = useroneAndPostoneMapper.selectMoreAndOne(1);
        sqlSession.commit();
        sqlSession.close();
        System.out.println(JSONObject.toJSONString(list));
    }
}
