package com.ywz.furns.dao;

import com.ywz.furns.bean.OrderItem;

/**
 * @author 于汶泽
 */
public interface OrderItemDAO {
    //报orderItem对象保存到数据库中
    public int saveOrderItem(OrderItem orderItem);
    //
}
