package mybatis_test;

import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by zhurenzhen on 2017/11/24.
 */
public class mybatis_test1 {
    @Test
    public void test1() throws IOException {
        // mybatis全局配置文件
        String resource = "SqlMapConfig.xml";

        // 根据mybatis的全局配置构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //  创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 使用sqlSession查询用户
        User user = sqlSession.selectOne("user.findUserById", 1);
        System.out.println(user);
        // 关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        // mybatis全局配置文件
        String resource = "SqlMapConfig.xml";

        // 根据mybatis的全局配置构造一个流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //  创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 使用sqlSession查询用户
        List user = sqlSession.selectList("user.findByUserName","%张%");
        System.out.println(user);
        // 关闭sqlSession
        sqlSession.close();
    }
}
