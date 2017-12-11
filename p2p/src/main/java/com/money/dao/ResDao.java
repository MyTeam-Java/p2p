package com.money.dao;


import com.money.entity.Res;
import com.money.vo.ResJson;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ResDao {
    //tree
    List<Res> findAllRes(int id);

    //所有展示
    List<ResJson> findAllResource(Map<String, Object> data);

    //分配角色
    List<Res> findAllResForRole();

    void saveRes(Res res);

    List<Res> findAllResForComebox();

    int getCountRes();

    void updateRes(Res res);

    List<Res> findResForRole();
}
