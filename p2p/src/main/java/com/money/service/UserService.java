package com.money.service;


import com.money.dao.UserDao;
import com.money.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //查找所有用户
    public List<User> findAllUser() {

        return userDao.findAllUser();
    }

    //查找所有用户+角色
    public List<User> findUserRole(Map<String, Integer> data) {
        return userDao.findUserRole(data);
    }

    public int getCount() {
        return userDao.getCount();
    }
    //添加用户
    public void saveUser(User user) {

        userDao.saveUser(user);
    }

    //删除用户
//    public void deleteUser(int id) {
//        userDao.deleteUser(id);
//    }
    public void deleteUser(ArrayList<Integer> data) {
        userDao.deleteUser(data);
    }

    //更新用户
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    //添加角色
    public void assignUserRole(int uid, int roid) {
        Map<String, Object> map = new HashMap<>();
        map.put("uid", uid);
        map.put("roid", roid);
        userDao.assignUserRole(map);
    }

    public User login(User user) {
        return userDao.login(user);
    }

    public User findUserByAccount(String account) {
        return userDao.findUserByAccount(account);
    }
}
