package com.money.controller;

import com.money.entity.Res;
import com.money.entity.User;
import com.money.service.ResService;
import com.money.vo.ResJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ResourceController {

    @Resource
    private ResService resService;

    @RequestMapping("findAllRes")
    public List<Res> findAllRes(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return resService.findAllRes(user.getUid());
    }

    @RequestMapping("findAllResource")
    public Map<String, Object> findAllResource(int page, int size) {
        int start = (page - 1) * size;
        Map<String, Object> data = new HashMap<>();
        data.put("start",start);
        data.put("size",size);
        List<ResJson> list = resService.findAllResource(data);
        Map<String, Object> map = new HashMap<>();
        map.put("rows",list);
        return map;
    }

    @RequestMapping("getCountRes")
    public int getCountRes() {
        return resService.getCountRes();
    }

    @RequestMapping("findAllResForRole")
    public List<Res> findAllResForRole() {
        return resService.findAllResForRole();
    }

    @RequestMapping("findAllResForComebox")
    public List<Res> findAllResForComebox() {
        return resService.findAllResForComebox();
    }

    @RequestMapping("saveRes")
    public String  saveRes(Res res) {
        int id = res.getId();
        if (id != 0) {
            resService.updateRes(res);
        }else {
            resService.saveRes(res);
        }
        return "1";
    }
}
