package com.money.dao;


import com.money.entity.Res;
import com.money.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface RoleDao {

    //查询所有角色
    List<Role> findAllRole(Map<String, Integer> data);

    //增加角色
    void saveRole(Role role);

    //删除角色
    void deleteRole(ArrayList<Integer> data);

    //修改角色
    void updateRole(Role role);

    //获取角色总条数
    int  getCountRole();

    //删除已有资源
    void deleteOldRes(Object roid);

    //分配资源
    void distribution(Map<String, Object> data);

    //获取角色已有资源
    List<Res> getResForRole(Role role);
}
