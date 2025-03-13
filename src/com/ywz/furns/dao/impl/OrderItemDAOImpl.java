package com.ywz.furns.dao.impl;

import com.ywz.furns.bean.OrderItem;
import com.ywz.furns.dao.BasicDAO;
import com.ywz.furns.dao.OrderItemDAO;

import java.util.List;

/**
 * @author 于汶泽
 */
public class OrderItemDAOImpl extends BasicDAO<OrderItem> implements OrderItemDAO {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into order_item(id,name,price,count,total_price,order_id) values(?,?,?,?,?,?)";
        return update(sql, orderItem.getId(), orderItem.getName(), orderItem.getPrice(), orderItem.getCount(), orderItem.getTotal_price(), orderItem.getOrder_id());
    }

    @Override
    public List<OrderItem> getOrderItems(String num) {
        String sql = "select * from order_item where order_id=?";
        return queryMulti(sql, OrderItem.class, num);
    }
}
