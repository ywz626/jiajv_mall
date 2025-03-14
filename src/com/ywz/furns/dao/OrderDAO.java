package com.ywz.furns.dao;

import com.ywz.furns.bean.Order;

import java.util.List;

/**
 * @author 于汶泽
 */
public interface OrderDAO {
    //想表中插入数据
    public int saveOrder(Order order);
    //获取 order对象
    public Order getOrder(String number);
    //获取 所有order对象
    public List<Order> getOrders(int id);
}
