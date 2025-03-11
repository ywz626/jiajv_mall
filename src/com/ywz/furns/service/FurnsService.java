package com.ywz.furns.service;

import com.ywz.furns.bean.Furn;

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
}
