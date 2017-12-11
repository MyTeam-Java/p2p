package com.money.service;

import com.money.dao.RoleDao;
import com.money.entity.Res;
import com.money.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public List<Role> findAllRole(Map<String, Integer> data) {
        return roleDao.findAllRole(data);
    }

    public String deleteRole(ArrayList<Integer> data) {
        roleDao.deleteRole(data);
        return "delete";
    }

    public String saveRole(Role role) {
        roleDao.saveRole(role);
        return "save";
    }

   public String updateRole(Role role) {
        roleDao.updateRole(role);
        return "update";
    }

    public int getCountRole() {

        return roleDao.getCountRole();
    }

    @Transactional
    public void distribution(Map<String, Object> data) {
        roleDao.deleteOldRes(data.get("roid"));
        roleDao.distribution(data);
    }

    public List<Res> getResForRole(Role role) {
        return roleDao.getResForRole(role);
    }
}
