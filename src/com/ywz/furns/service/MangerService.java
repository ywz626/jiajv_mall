package com.ywz.furns.service;

import com.ywz.furns.bean.Manger;
import com.ywz.furns.bean.User;

/**
 * @author 于汶泽
 */
public interface MangerService {
    public Manger checkPwd(String name, String pwd);
}
