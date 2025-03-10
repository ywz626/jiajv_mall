package com.ywz.furns.dao.impl;

import com.ywz.furns.bean.User;
import com.ywz.furns.dao.BasicDAO;
import com.ywz.furns.dao.UserDAO;

/**
 * @author 于汶泽
 */
public class UserDAOimpl extends BasicDAO<User> implements UserDAO {
    //通过用户名获取User对象的方法
    @Override
    public User getUser(String username) {
        String sql = "select * from user where name=?";
        User user = querySingle(sql, User.class, username);
        return user;
    }
    //通过传入一个User对象输入到数据库中 如果是-1表示输入失败，其他整数表示成功
    @Override
    public int saveUser(User user) {
        String sql = "insert into user(name,pwd,email) values(?,?,?)";
        return update(sql, user.getName(), user.getPwd(), user.getEmail());
    }
    //判断与用户名匹配的密码是否正确

    @Override
    public User checkPassword(String username, String password) {
        String sql = "select * from user where name=? and pwd=?";
        User user = querySingle(sql, User.class, username,password);
        return user;
    }
}
