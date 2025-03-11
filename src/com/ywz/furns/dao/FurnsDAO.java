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
    //通过传入 一个Furn对象来删除该家具
    public int deleteFurn(Furn furn);
    //修改家具信息
    public int updateFurn(Furn furn);
    //通过传入 id来获取Furn对象
    public Furn getFurn(Integer id);
    // 获取总共有多少行数据
    public int getTotalRows();
    // 获取一页中的数据集合
    public List<Furn> getPageData(int begin,int limit);
}
