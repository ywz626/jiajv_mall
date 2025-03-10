package com.ywz.furns.service.impl;

import com.ywz.furns.bean.User;
import com.ywz.furns.dao.UserDAO;
import com.ywz.furns.dao.impl.UserDAOimpl;
import com.ywz.furns.service.UserService;

/**
 * @author 于汶泽
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOimpl();
    @Override
    public boolean isUsernameExist(String username) {
        //通过用户名判断是否有用户已存在 如果是false表示没有该用户，否则已存在
        User user = userDAO.getUser(username);
        if(user==null) {
            return false;
        } else {
            return true;
        }
    }

    //将用户数据放入数据库的方法
    @Override
    public boolean login(User user) {
        return userDAO.saveUser(user)==-1?false:true;
    }
    //返回true代表密码正确，否则密码错误
    @Override
    public User checkPwd(String name,String pwd)
    {
        return userDAO.checkPassword(name,pwd);
    }
}
