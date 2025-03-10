package com.ywz.furns.dao;

import com.ywz.furns.bean.User;

/**
 * @author 于汶泽
 */
public interface UserDAO {
    public User getUser(String username);

    //保存User对象到数据库的方法
    public int saveUser(User user);

    //判断与用户名匹配的密码是否正确（于汶泽版）
    public User checkPassword(String username, String password);
}
