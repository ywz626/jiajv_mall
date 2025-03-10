package com.ywz.furns.service;

import com.ywz.furns.bean.User;

/**
 * @author 于汶泽
 */
public interface UserService {
    //注册用户
    public boolean login(User user);

    //判断用户名是否存在
    //如果存在返回true 否则返回false
    public boolean isUsernameExist(String username);
    //在给出用户名的前提下判断密码是否正确
    public User checkPwd(String name,String pwd);
}
