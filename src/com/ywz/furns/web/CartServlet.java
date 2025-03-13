package com.ywz.furns.web;

import com.ywz.furns.Utils.DbUtils;
import com.ywz.furns.bean.Cart;
import com.ywz.furns.bean.CartItem;
import com.ywz.furns.bean.Furn;
import com.ywz.furns.bean.Page;
import com.ywz.furns.service.FurnsService;
import com.ywz.furns.service.impl.FurnsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 于汶泽
 */
public class CartServlet extends BasicServlet{
    private FurnsService furn = new FurnsServiceImpl();

    public void addCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String id1 = req.getParameter("id");
//        System.out.println(id1);
        int id = DbUtils.getInt(req.getParameter("id"),0);
        Furn furnById = furn.getFurnById(id);
        int count = 1;
        if(furnById!=null){
            CartItem cartItem = new CartItem(furnById.getId(), furnById.getName(), furnById.getPrice(), count, furnById.getPrice());
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            if(cart == null){
                cart = new Cart();
                req.getSession().setAttribute("cart",cart);
            }
            cart.addItem(cartItem);
//            System.out.println(cart.getCartItems().size());
            //System.out.println(cart);
//            req.getSession().setAttribute("cart",cart);
            String referer = req.getHeader("Referer");
            resp.sendRedirect(referer);
        }else {
            return;
        }
    }
    //在购物车中的更新物品数量操作
    public void update(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        int id = DbUtils.getInt(req.getParameter("id"),0);
        int count = DbUtils.getInt(req.getParameter("count"),0);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        cart.setCount(id,count);
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);
    }
    // 根据传入id 删除购物车中的某样家具
    public void deleteById(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        int id = DbUtils.getInt(req.getParameter("id"),0);
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        cart.removeItem(id);
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);
    }
    // 清空购物车
    public void deleteAll(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        req.getSession().removeAttribute("cart");
        resp.sendRedirect("index.jsp");
    }
}
