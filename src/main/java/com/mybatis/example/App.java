package com.mybatis.example;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args )throws Exception{
//        test0();
        test();
        test1();
        test2();
        test3();
    }

    /**
     * Environment 的使用
     * @throws IOException
     */
    public static void test() throws IOException {
        String resource = "mybatis-config-env.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"local_test");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        System.out.println(JSONObject.toJSONString(sqlSession.getMapper(BlogMapper.class).selectBlog(4)));

    }


    public static void test0() throws Exception{

        String resource = "com/mybatis/example/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        //第三步：接口调用方法执行sql
        System.out.println(JSONObject.toJSONString(blogMapper.selectBlog(1)));
    }

    public static void test1() throws Exception{
        /**
         * 加载相对路径
         */
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        //第三步：接口调用方法执行sql
        System.out.println(JSONObject.toJSONString(blogMapper.selectByUsername("shanghai")));
    }

    public static void test2() throws Exception{
        /**
         * 加载绝对路径
         */
        String resource = "D:\\idea2017_workspace\\mybatis-example\\src\\main\\resources\\mybatis-config.xml";
        InputStream configFile = new FileInputStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        //加载配置文件得到SqlSessionFactory
        SqlSession sqlSession= sqlSessionFactory.openSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        System.out.println(JSONObject.toJSONString(blogMapper.selectBlog(2)));
    }

    public static void test3() throws Exception{
        String resource = "spring/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        System.out.println(JSONObject.toJSONString(blogMapper.selectBlog(3)));
    }
}
