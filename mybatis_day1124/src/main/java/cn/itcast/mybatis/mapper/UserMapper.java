package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.User;

import java.util.List;

/**
 * Created by zhurenzhen on 2017/11/24.
 */
public interface UserMapper {
    // 根据用户id查询用户信息
    public User findUserById(int id);
    // 根据用户名称模糊查询
    public List<User> findByUserName(String username);
}
