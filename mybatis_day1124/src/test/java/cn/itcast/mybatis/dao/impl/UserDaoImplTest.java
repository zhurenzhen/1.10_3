package cn.itcast.mybatis.dao.impl;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Created by zhurenzhen on 2017/11/24.
 */
public class UserDaoImplTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        // 创建sqlSessionFactory,mybatis全局文件
        String resource = "SqlMapConfig.xml";

        // 根据mybatis的全局文件构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserByUserId() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);

        // 调用UserDao的方法
        User user = userDao.findUserByUserId(1);
        System.out.println(user);


    }

}