package com.ywz.furns.service;

import com.ywz.furns.bean.Cart;
import com.ywz.furns.bean.Order;
import com.ywz.furns.bean.OrderItem;

import java.util.List;

/**
 * @author 于汶泽
 */
public interface OrderService {
    // 通过cart和会员id 把数据传入 order。数据库中
    public String saveOrder(Cart cart,int id);
    // 获取order对象
    public Order getOrder(String number);
    // 获取orderItem集合
    public List<OrderItem> getOrderItems(String num);
}
