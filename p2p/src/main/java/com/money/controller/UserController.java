package com.money.controller;

import com.alibaba.fastjson.JSON;
import com.money.entity.User;
import com.money.service.UserService;
import com.money.util.MessageUtil;
import com.money.util.SecurityUtil;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableScheduling   //启动调度
public class UserController {
    
    @Resource
    private UserService userService;

    //查找所有用户
    @RequestMapping("findAllUser")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    //查找用户+角色
    @RequestMapping("findUserRole")
    public List<User> findUserRole(int page, int size) {
        int start = (page - 1) * size;
        Map<String, Integer> data = new HashMap<>();
        data.put("start",start);
        data.put("size",size);
        return userService.findUserRole(data);
    }

    @RequestMapping("getCount")
    public int getCount() {
        return userService.getCount();
    }
    //添加用户
    @RequestMapping("saveUser")
    public String saveUser(User user) {
        int id = user.getUid();
        if (id != 0) {
            //更新用户
            userService.updateUser(user);
        }else {
            String x = SecurityUtil.encrypt(user.getPwd());
            user.setPwd(x);
            userService.saveUser(user);
        }

        return "save";
    }

    //删除用户
    @RequestMapping("deleteUser")
    public String deleteUser(@RequestBody ArrayList<Integer> data) { //必须使用Integer，int是基本数据类型，不能作为泛型
        userService.deleteUser(data);
        return "delete";
    }

    //分配角色
    @RequestMapping("assignRole")
    public String assignRole(int uid, int roid) {
         userService.assignUserRole(uid, roid);
         return "assign";
    }

   //登录
    @RequestMapping("login")
    public String login(User user, HttpSession session) {
        String x = SecurityUtil.encrypt(user.getPwd());
        user.setPwd(x);
        User u = userService.login(user);
        if (u == null)  {
            return "用户" + user.getAccount() + "不存在";
        }
        //保存当前用户到session
        session.setAttribute("user",u);
        return "1";
    }

    //根据账号查找用户
    @RequestMapping("findUserByAccount/{account}")
    public String findUserByAccount(@PathVariable String account) {
        User user = userService.findUserByAccount(account);
        String json = JSON.toJSONString(user);
        return json;
    }

    //给会员发短信
    @Scheduled(cron = "0 55-56 15 * * ?")
    public String sendMessage() {
        //查找会员信息的集合
        List<User> list = userService.findAllUser();
        for (User u : list) {
            MonthDay today = MonthDay.now();
            System.out.println(today);
            System.out.println("外层生日：" + u.getBirthday());
            System.out.println(today.toString().equals(u.getBirthday()));
            if (today.toString().equals(u.getBirthday())) {
                //发短信
                System.out.println(u.getBirthday() + "----------");
                MessageUtil.sendMessage(u.getPhone());
            }
        }
        return "1";
    }
}
