package com.ywz.furns.dao;

import com.ywz.furns.bean.OrderItem;

import java.util.List;

/**
 * @author 于汶泽
 */
public interface OrderItemDAO {
    //报orderItem对象保存到数据库中
    public int saveOrderItem(OrderItem orderItem);
    // 获取orderItem对象集合
    public List<OrderItem> getOrderItems(String num);
}
