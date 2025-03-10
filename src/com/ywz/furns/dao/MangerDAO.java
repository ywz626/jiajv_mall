package com.ywz.furns.dao;

import com.ywz.furns.bean.Manger;
import com.ywz.furns.bean.User;

/**
 * @author 于汶泽
 */
public interface MangerDAO {
    public Manger getManger(String name);

    //判断与用户名匹配的密码是否正确（于汶泽版）
    public Manger checkPassword(String name, String password);
}
