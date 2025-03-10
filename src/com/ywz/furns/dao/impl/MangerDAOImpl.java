package com.ywz.furns.dao.impl;

import com.ywz.furns.bean.Manger;
import com.ywz.furns.bean.User;
import com.ywz.furns.dao.BasicDAO;
import com.ywz.furns.dao.MangerDAO;

/**
 * @author 于汶泽
 */
public class MangerDAOImpl extends BasicDAO<Manger> implements MangerDAO {
    @Override
    public Manger getManger(String name) {
        String sql = "select * from  manage where name=?";
        Manger manger = querySingle(sql, Manger.class, name);
        return manger;
    }

    @Override
    public Manger checkPassword(String name, String password) {
        String sql = "select * from manage where name=? and pwd=?";
        Manger manger = querySingle(sql, Manger.class, name,password);
        return manger;
    }
}
