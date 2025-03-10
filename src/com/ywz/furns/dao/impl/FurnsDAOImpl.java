package com.ywz.furns.dao.impl;

import com.ywz.furns.bean.Furn;
import com.ywz.furns.dao.BasicDAO;
import com.ywz.furns.dao.FurnsDAO;

import java.util.List;

/**
 * @author 于汶泽
 */
public class FurnsDAOImpl extends BasicDAO<Furn> implements FurnsDAO {
    @Override
    public List<Furn> getAllFurns() {
        String sql = "SELECT * FROM furns";
        return queryMulti(sql, Furn.class);
    }

    @Override
    public int insertFurn(Furn furn) {
        String sql = "insert into furns(name,maker,price,sales,stock) values(?,?,?,?,?)";
        return update(sql, furn.getName(),furn.getMaker(),furn.getPrice(),furn.getSales(),furn.getStock());
    }
}
