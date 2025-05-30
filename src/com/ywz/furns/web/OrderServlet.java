package com.ywz.furns.web;

import com.ywz.furns.bean.Cart;
import com.ywz.furns.bean.Order;
import com.ywz.furns.bean.OrderItem;
import com.ywz.furns.bean.User;
import com.ywz.furns.service.UserService;
import com.ywz.furns.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 于汶泽
 */
public class OrderServlet extends BasicServlet {
    private OrderServiceImpl orderService = new OrderServiceImpl();

    public void saveOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        if (user == null) {
            resp.sendRedirect("views/member/login.jsp");
            return;
        }
        if (cart == null) {
            resp.sendRedirect("index.jsp");
            return;
        }
        String num = orderService.saveOrder(cart, user.getId());
        session.setAttribute("num", num);
        resp.sendRedirect("views/order/checkout.jsp");
    }

    public void search(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String num = (String) req.getSession().getAttribute("num");
        if (num != null) {
            Order ord = orderService.getOrder(num);
            List<Order> order = new ArrayList<>();
            order.add(ord);
            req.setAttribute("order", order);
            req.getRequestDispatcher("views/order/order.jsp").forward(req, resp);
        }
    }

    // 展示一个订单中的商品
    public void detail(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String num = req.getParameter("num");
        List<OrderItem> orderItems = orderService.getOrderItems(num);
        Order order = orderService.getOrder(num);
        for (OrderItem orderItem : orderItems) {
            order.setTotal_count(order.getTotal_count()+orderItem.getCount());
            order.setTotal_price(order.getTotal_price().add(orderItem.getTotal_price()));
        }
        req.setAttribute("order", order);
        req.setAttribute("orderItems", orderItems);
        req.getRequestDispatcher("views/order/order_detail.jsp").forward(req, resp);
    }

    //展示所有订单
    public void searchAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");
        List<Order> orders = orderService.getOrders(user.getId());
        req.setAttribute("order", orders);
        req.getRequestDispatcher("views/order/order.jsp").forward(req, resp);
    }
}
