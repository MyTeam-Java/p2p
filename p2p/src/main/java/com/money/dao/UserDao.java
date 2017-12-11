package com.money.dao;


import com.money.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserDao {

    //查找所有
    List<User> findAllUser();

    //添加用户
    void saveUser(User user);

    //删除用户
    //void deleteUser(int id);
    void deleteUser(ArrayList<Integer> data);

    //修改信息
    void updateUser(User user);

    //添加角色信息
    void assignUserRole(Map map);

    //查询所有用户及对应的角色
    List<User> findUserRole(Map<String, Integer> data);

    //得到数据总条数
    int getCount();

    //登录验证
    User login(User user);

    User findUserByAccount(String account);
}
