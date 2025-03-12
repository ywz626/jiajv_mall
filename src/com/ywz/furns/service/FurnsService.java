package com.ywz.furns.service;

import com.ywz.furns.bean.Furn;
import com.ywz.furns.bean.Page;

import java.util.List;

/**
 * @author 于汶泽
 */
public interface FurnsService {
    public List<Furn> getFurns();
    public boolean addFurn(Furn furn);
    public boolean deleteFurn(Furn furn);
    public boolean updateFurn(Furn furn);
    public Furn getFurnById(Integer id);
    public Page<Furn> getPage(Integer pageNo, Integer pageSize);
    //通过模糊查询 获取Page
    public Page<Furn> getPage(String name, Integer pageNo, Integer pageSize);
}
