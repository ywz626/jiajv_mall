package com.ywz.furns.dao;

import com.ywz.furns.bean.Furn;

import java.util.List;

/**
 * @author 于汶泽
 */
public interface FurnsDAO {
    //获取所有家具集合的方法
    public List<Furn> getAllFurns();
}
