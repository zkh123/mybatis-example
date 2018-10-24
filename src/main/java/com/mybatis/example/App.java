package com.mybatis.example;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.example.dao.BlogMapper;
import com.mybatis.example.dao.MovieMapper;
import com.mybatis.example.dao.PingTBMapper;
import com.mybatis.example.entity.Movie;
import com.mybatis.example.entity.PingTB;
import com.mybatis.example.dao.UserMapper;
import com.mybatis.example.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
//        test66();
//        test6();
//        test7();
//        test8();
        test9();
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
    public static void test66() throws Exception{
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


    public static void test6() throws Exception{
        /**
         * 加载相对路径
         */
        String resource = "spring/mybatis-config-pingTB.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        PingTBMapper pingTBMapper = sqlSession.getMapper(PingTBMapper.class);
        //第三步：接口调用方法执行sql
        List<PingTB> list = pingTBMapper.selectPingById(1);
        System.out.println(JSONObject.toJSONString(list));

        List<PingTB> list1 = pingTBMapper.selectPingByBizId(1201);
        System.out.println(JSONObject.toJSONString(list1));

        List<Map<String,Object>> list2 = pingTBMapper.selectPingByBizId2(1201);
        System.out.println(JSONObject.toJSONString(list2));

        List<Map<String,Object>> list3 = pingTBMapper.selectPingByBizId3(1201);
        System.out.println(JSONObject.toJSONString(list3));

        List<PingTB> list4 = pingTBMapper.selectPingByBizId4(1201);
        System.out.println(JSONObject.toJSONString(list4));

        PingTB pingTB = new PingTB();
        pingTB.setUserid(1000);
        pingTB.setListingid(-1);
        pingTB.setBizid(1201);
        pingTB.setZuid(103);
        pingTB.setDingid(-1);
        pingTB.setMonths(-2);
        pingTB.setCreditScore(-1.0000000000000000f);
        pingTB.setCreditLevel("B");
        pingTB.setCreditBin(-1);
        pingTB.setCreditLevelPro("BB");
        pingTB.setModelLabel("appyi");
        pingTB.setModelVer("v3_201804");
        pingTB.setProcessFlag(1);
        pingTB.setBlockDays(300);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a","123454");
        jsonObject.put("b","上海");
        pingTB.setInfo(JSONObject.toJSONString(jsonObject));
        Integer size = pingTBMapper.insertOne(pingTB);
        sqlSession.commit();  //千万不要忘记commit提交动作
        sqlSession.close();
        System.out.println(size);




    }

    public static void test7() throws Exception{
        /**
         * 加载相对路径
         */
        String resource = "spring/mybatis-config-pingTB.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        PingTBMapper pingTBMapper = sqlSession.getMapper(PingTBMapper.class);
        //第三步：接口调用方法执行sql
        List<PingTB> list = new ArrayList<PingTB>();
        for (int i = 0 ; i < 50; i++){
            PingTB pingTB = new PingTB();
            pingTB.setUserid(1000);
            pingTB.setListingid(-1);
            pingTB.setBizid(1201);
            pingTB.setZuid(103);
            pingTB.setDingid(-1);
            pingTB.setMonths(-2);
            pingTB.setCreditScore(-1.0000000000000000f);
            pingTB.setCreditLevel("B");
            pingTB.setCreditBin(-1);
            pingTB.setCreditLevelPro("BB");
            pingTB.setModelLabel("appyi");
            pingTB.setModelVer("v3_201804");
            pingTB.setProcessFlag(1);
            pingTB.setBlockDays(300);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("a","123454");
            jsonObject.put("b","上海");
            pingTB.setInfo(JSONObject.toJSONString(jsonObject));
            list.add(pingTB);
        }
        Integer size = pingTBMapper.batchInsert(list);
        sqlSession.commit();  //千万不要忘记commit提交动作
        sqlSession.close();
        System.out.println(size);
    }


    public static void test8() throws Exception{
        /**
         * 加载相对路径
         */
        String resource = "spring/mybatis-config-pingTB.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        PingTBMapper pingTBMapper = sqlSession.getMapper(PingTBMapper.class);
        //第三步：接口调用方法执行sql
        PingTB pingTB = new PingTB();
        pingTB.setId(56);
//        update ping_tb set userid = #{userid},listingid = #{listingid},bizid = #{bizid},process_flag = #{processFlag},info = #{info},updatetime = NOW() where id = #{id}
        pingTB.setUserid(2000);
        pingTB.setListingid(-20);
        pingTB.setBizid(110);
        pingTB.setProcessFlag(-1);
        JSONObject info = new JSONObject();
        info.put("上海","shanghai");
        info.put("北京","beijing");
        pingTB.setInfo(JSONObject.toJSONString(info));
        Integer size = pingTBMapper.updateById(pingTB);
        sqlSession.commit();  //千万不要忘记commit提交动作
        sqlSession.close();
        System.out.println(size);
    }


    public static void test9() throws Exception{
        /**
         * 加载相对路径
         */
        String resource = "spring/mybatis-config-pingTB.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //第一步：拿到sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第二步：拿到Mapper接口实例
        PingTBMapper pingTBMapper = sqlSession.getMapper(PingTBMapper.class);
        //第三步：接口调用方法执行sql
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(56);
        List<PingTB> pingTBList = pingTBMapper.batchSelect(list);
        sqlSession.commit();  //千万不要忘记commit提交动作
        sqlSession.close();
        System.out.println(JSONObject.toJSONString(pingTBList));
    }
}
