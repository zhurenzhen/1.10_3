package cn.itcast.mybatis.dao.impl;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by zhurenzhen on 2017/11/24.
 */
public class UserDaoImpl implements UserDao {

    // 接口实现类中注入sqlSessionFactory
    private SqlSessionFactory sqlSessionFactory;

    // 通过构造方法注入
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    // 根据用户id查询用户信息
    @Override
    public User findUserByUserId(int id) {
        // sqlSession定义为局部变量
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("user.findUserById", id);
        sqlSession.close();
        return user;
    }
}
