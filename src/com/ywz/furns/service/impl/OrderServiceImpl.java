package com.ywz.furns.service.impl;

import com.ywz.furns.bean.*;
import com.ywz.furns.dao.FurnsDAO;
import com.ywz.furns.dao.OrderDAO;
import com.ywz.furns.dao.OrderItemDAO;
import com.ywz.furns.dao.impl.FurnsDAOImpl;
import com.ywz.furns.dao.impl.OrderDAOImpl;
import com.ywz.furns.dao.impl.OrderItemDAOImpl;
import com.ywz.furns.service.OrderService;

import java.util.Date;
import java.util.List;

/**
 * @author 于汶泽
 */
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
    private FurnsDAO furnsDAO = new FurnsDAOImpl();

    @Override
    public List<OrderItem> getOrderItems(String num) {
        return orderItemDAO.getOrderItems(num);
    }

    @Override
    public Order getOrder(String number) {
        return orderDAO.getOrder(number);
    }

    @Override
    public String saveOrder(Cart cart, int id) {
        Order order = new Order();
        order.setDate(new Date());
        order.setMumber_id(id);
        order.setPrice(cart.getTotalPrice());
        order.setStatus(0);
        order.setNumber(System.currentTimeMillis()+"");
        orderDAO.saveOrder(order);
        for (CartItem c: cart.getMapValue()) {
            OrderItem orderItem = new OrderItem(null,c.getName(),c.getPrice(),c.getCount(),c.getTotalPrice(),order.getNumber());
            orderItemDAO.saveOrderItem(orderItem);
            Furn furn = furnsDAO.getFurn(c.getId());
            furn.setSales(furn.getSales()+c.getCount());
            furn.setStock(furn.getStock()-c.getCount());
            furnsDAO.updateFurn(furn);
        }
        cart.clean();
        return order.getNumber();
    }
}
