package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.pojo.User;

/**
 * Created by zhurenzhen on 2017/11/24.
 */
public interface UserDao {
    // 根据用户id查询用户信息
    public User findUserByUserId(int id);
}
