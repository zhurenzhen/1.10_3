package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zhurenzhen on 2017/11/24.
 */
public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        // 创建sqlSessionFactory
        // mabatis全局配置文件
        String resource = "SqlMapConfig.xml";
        // 根据mybatis全局配置文件构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }
    @Test
    public void findUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 生成代理对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 调用mapper
        User user = mapper.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void findByUserName(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.findByUserName("张");
        System.out.println(user);


    }
}