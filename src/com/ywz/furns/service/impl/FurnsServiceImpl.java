package com.ywz.furns.service.impl;

import com.ywz.furns.bean.Furn;
import com.ywz.furns.dao.impl.FurnsDAOImpl;
import com.ywz.furns.service.FurnsService;

import java.util.List;

/**
 * @author 于汶泽
 */
public class FurnsServiceImpl implements FurnsService {
    private FurnsDAOImpl furnsDAO = new FurnsDAOImpl();
    @Override
    public List<Furn> getFurns() {
        return furnsDAO.getAllFurns();
    }

    @Override
    public boolean addFurn(Furn furn) {
        return furnsDAO.insertFurn(furn) != -1;
    }
}
