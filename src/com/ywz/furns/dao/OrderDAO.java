package com.ywz.furns.dao;

import com.ywz.furns.bean.Order;

/**
 * @author 于汶泽
 */
public interface OrderDAO {
    //想表中插入数据
    public int saveOrder(Order order);
    //获取 order对象
    public Order getOrder(String number);
}
