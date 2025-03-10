package com.ywz.furns.dao;

import com.ywz.furns.bean.Furn;

import java.util.List;

/**
 * @author 于汶泽
 */
public interface FurnsDAO {
    //获取所有家具集合的方法
    public List<Furn> getAllFurns();
    //通过传入 Furn类型来在数据库中插入家具
    public int insertFurn(Furn furn);
}
