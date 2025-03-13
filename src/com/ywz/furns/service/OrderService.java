package com.ywz.furns.service;

import com.ywz.furns.bean.Cart;

/**
 * @author 于汶泽
 */
public interface OrderService {
    // 通过cart和会员id 把数据传入 order。数据库中
    public String saveOrder(Cart cart,int id);
}
