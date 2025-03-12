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

    @Override
    public int deleteFurn(Furn furn) {
        String sql = "delete from furns where id=?";
        return update(sql, furn.getId());
    }

    @Override
    public int updateFurn(Furn furn) {
        String sql = "update furns set name=?,maker=?,price=?,sales=?,stock=? " +
                "where id=?";
        return update(sql,furn.getName(),furn.getMaker(),furn.getPrice(),
        furn.getSales(),furn.getStock(),furn.getId());
    }

    @Override
    public Furn getFurn(Integer id) {
        String sql = "select * from Furns where id=?";
        return querySingle(sql, Furn.class, id);
    }

    @Override
    public int getTotalRows() {
        String sql = "select count(*) from furns";
        return ((Number)queryScalar(sql)).intValue();
    }

    @Override
    public List<Furn> getPageData(int begin, int limit) {
        String sql = "select * from furns order by id asc limit ? offset ?";
        return queryMulti(sql, Furn.class, limit,begin);
    }

    @Override
    public List<Furn> getPageData(String name, int begin, int limit) {
        String sql = "select * from furns where name like ? order by id asc limit ? offset ?";
        return queryMulti(sql, Furn.class,"%" + name + "%", limit, begin);
    }
    public int getTotalRows(String name){
        String sql = "select count(*) from furns where name like ?";
        return ((Number)queryScalar(sql, "%" + name + "%")).intValue();
    }
}
