package com.mybatis.example;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.example.dao.BlogMapper;
import com.mybatis.example.dao.MovieMapper;
import com.mybatis.example.dao.UserMapper;
import com.mybatis.example.entity.Movie;
import com.mybatis.example.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args )throws Exception{
//        test0();
//        test();
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();
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

    /**
     * mybatis配置文件中 参数外部properties文件传递
     * @throws Exception
     */
    public static void test4() throws Exception{
        String resource = "mybatis-config-property.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        BlogMapper blogMapper = sqlSession1.getMapper(BlogMapper.class);
        System.out.println(JSONObject.toJSONString(blogMapper.selectByUsername("shanghai")));

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        MovieMapper movieMapper = sqlSession2.getMapper(MovieMapper.class);
        System.out.println(JSONObject.toJSONString(movieMapper.getList().size()));
    }

    /**
     * 手动传递properties对象 传递参数到mybatis配置文件中
     * @throws Exception
     */
    public static void test5() throws Exception{
        String resource = "mybatis-config-property-out.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        Properties properties = new Properties();
        properties.setProperty("driver","com.mysql.cj.jdbc.Driver");
        properties.setProperty("url","jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        properties.setProperty("password","");
        properties.setProperty("username","root");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,properties);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        BlogMapper blogMapper = sqlSession1.getMapper(BlogMapper.class);
//        System.out.println(JSONObject.toJSONString(blogMapper.selectByUsername("shanghai")));

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        MovieMapper movieMapper = sqlSession2.getMapper(MovieMapper.class);
//        System.out.println(JSONObject.toJSONString(movieMapper.getList().size()));
        List<Map<String,Object>> list = movieMapper.getByDirector("尔冬升");
//        System.out.println(JSONObject.toJSONString(list));

        List<Movie> list1 = movieMapper.selectShowtime(2005);
//        System.out.println(JSONObject.toJSONString(list1));

        List<Map<String,Object>> list2 = movieMapper.selectComposer("尔冬升");
//        System.out.println(JSONObject.toJSONString(list2));

        List<Movie> list3 = movieMapper.selectRate(8f);
//        System.out.println(JSONObject.toJSONString(list3));  //JSONObject.toJSONString()

        List<Movie> list4 = movieMapper.selectById(1);
//        System.out.println(JSONObject.toJSONString(list4));

//        List<Map<String,Object>> list5 = movieMapper.getByDirectorT("尔冬升");
//        System.out.println(JSONObject.toJSONString(list5));

        List<Movie> list6 = movieMapper.selectByLanguage("英语");
//        System.out.println(JSONObject.toJSONString(list6));


        List<Movie> list7 = movieMapper.selectComposerHandler("尔冬升");
        System.out.println(JSONObject.toJSONString(list7));
    }


    /**
     * mybatis 中 typeHandler  有什么应用场景啊？
     * 类型转换 比如 枚举转
     * 性别  男女   表中存储 int 1/0  ui展示 男/女
     * @throws Exception
     */
    public static void test6() throws Exception{
        String resource = "mybatis-config-user.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession1.getMapper(UserMapper.class);

//        User user = userMapper.selectUserById(1);
//        System.out.println(JSONObject.toJSONString(user));

//        User user1 = userMapper.selectUserById(2);
//        System.out.println(JSONObject.toJSONString(user1));

//        List<User> list = userMapper.selectUser();
//        System.out.println(JSONObject.toJSONString(list));

        User user3 = userMapper.selectUserByIdTow(1);
        System.out.println(JSONObject.toJSONString(user3));

        User user4 = userMapper.selectUserByIdTow(2);
//        System.out.println(JSONObject.toJSONString(user4));

    }
}
