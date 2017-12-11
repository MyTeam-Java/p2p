package com.money.controller;

import com.money.entity.Res;
import com.money.entity.Role;
import com.money.service.ResService;
import com.money.service.RoleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private ResService resService;

    @RequestMapping("findAllRole")
    public List<Role> findAllRole(int page, int size) {
        int start = (page - 1) * size;
        Map<String, Integer> data = new HashMap<>();
        data.put("start",start);
        data.put("size",size);
        return roleService.findAllRole(data);
    }
    //添加角色
    @RequestMapping("saveRole")
    public String saveRole(Role role) {
        int id = role.getRoid();
        if (id != 0) {
            //更新角色
            roleService.updateRole(role);
        }else {
            roleService.saveRole(role);
        }

        return "save";
    }

    //删除角色
    @RequestMapping("deleteRole")
    /*public String deleteUser(int id) {
        userService.deleteUser(id);
        return "delete";
    }*/
    public String deleteRole(@RequestBody ArrayList<Integer> data) { //必须使用Integer，int是基本数据类型，不能作为泛型
        roleService.deleteRole(data);
        return "delete";
    }

    //查找角色总数
    @RequestMapping("getCountRole")
    public int getCountRole() {
        return roleService.getCountRole();
    }

    //获取角色已有权限
    @RequestMapping("getResForRole")
    public List<Res> getResForRole(@RequestBody Role role) {
        List<Res> list = roleService.getResForRole(role);
        List<Res> list2 = resService.findAllResForRole();
        //角色已有的资源
        for (Res res : list) {
            //所有资源
            for (Res res2 : list2) {
                if (res2.getText().equals(res.getText())) {
                    res2.setChecked(true);
                }
            }
        }
        return list2;
    }

    //分配权限
    @RequestMapping("distribution")
    public String distribution(@RequestBody ArrayList<Integer> args) {
        Map<String, Object> data = new HashMap<>();
        data.put("roid", args.get(0));
        args.remove(0);
        data.put("ps", args);
        roleService.distribution(data);
        return "1";
    }
}
