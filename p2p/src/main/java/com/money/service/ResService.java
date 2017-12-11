package com.money.service;

import com.money.dao.ResDao;
import com.money.entity.Res;
import com.money.vo.ResJson;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ResService {

    @Resource
    private ResDao resDao;

    @Cacheable(value = "findAllRes")
    public List<Res> findAllRes(int id) {
        return resDao.findAllRes(id);
    }

    public List<Res> findResForRole() {
        return resDao.findResForRole();
    }
    public List<ResJson> findAllResource(Map<String, Object> data) {
        return resDao.findAllResource(data);
    }

    public List<Res> findAllResForRole() {
        return resDao.findAllResForRole();
    }

    @CacheEvict(value = "findAllRes",allEntries = true)
    public void saveRes(Res res) {
        resDao.saveRes(res);
    }

    public List<Res> findAllResForComebox() {
        return resDao.findAllResForComebox();
    }

    public int getCountRes() {
        return resDao.getCountRes();
    }

    public void updateRes(Res res) {
        resDao.updateRes(res);
    }
}
