package com.ywz.furns.service.impl;

import com.ywz.furns.bean.Manger;
import com.ywz.furns.dao.MangerDAO;
import com.ywz.furns.dao.impl.MangerDAOImpl;
import com.ywz.furns.service.MangerService;

/**
 * @author 于汶泽
 */
public class MangerServiceImpl implements MangerService {
    private MangerDAO manger = new MangerDAOImpl();
    @Override
    public Manger checkPwd(String name, String pwd) {
        return manger.checkPassword(name, pwd);
    }
}
