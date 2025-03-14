package com.ywz.furns.dao.impl;

import com.ywz.furns.bean.Order;
import com.ywz.furns.dao.BasicDAO;
import com.ywz.furns.dao.OrderDAO;

import java.util.List;

/**
 * @author 于汶泽
 */
public class OrderDAOImpl extends BasicDAO<Order> implements OrderDAO {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into `order`(`number`,`date`,`price`,`status`,`member_id`) values(?,?,?,?,?)";
        return update(sql,order.getNumber(),order.getDate(),order.getPrice(),order.getStatus(),order.getMumber_id());
    }

    @Override
    public List<Order> getOrders(int id) {
        String sql = "select * from `order` where `member_id` = ?";
        return queryMulti(sql, Order.class,id);
    }

    @Override
    public Order getOrder(String number) {
        String sql = "select * from `order` where `number`=?";
        return querySingle(sql, Order.class, number);
    }
}
