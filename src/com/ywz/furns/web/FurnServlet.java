package com.ywz.furns.web;

import com.ywz.furns.bean.Furn;
import com.ywz.furns.service.impl.FurnsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author 于汶泽
 */
public class FurnServlet extends BasicServlet {
    private FurnsServiceImpl fsi = new FurnsServiceImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Furn> furns = fsi.getFurns();
        //System.out.println(furns);
        if (furns != null && furns.size() > 0) {
            System.out.println("成功");
            req.setAttribute("furns", furns);
            req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req, resp);
        }
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        //name = new String(name.getBytes("iso8859-1"), "utf-8");
        String maker = req.getParameter("maker");
        //maker = new String(maker.getBytes("iso8859-1"), "utf-8");
        String price = req.getParameter("price");
        String sales = req.getParameter("sales");
        String stock = req.getParameter("stock");
        BigDecimal price2 = new BigDecimal(price);
        Integer sale = Integer.parseInt(sales);
        Integer stock2 = Integer.parseInt(stock);
        System.out.println(name + " " + maker + " " + price2 + " " + sales + " " + stock2);
        Furn furn = new Furn(null, name, maker, price2, sale, stock2, null);
        if (fsi.addFurn(furn)) {
            System.out.println("添加家具成功");
            req.getRequestDispatcher("/manage/FurnServlet?action=login").forward(req,resp);
        } else {
            System.out.println("添加家具失败！！！");
        }
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        req.setCharacterEncoding("utf-8");
//        if ("login".equals(action)) {
//            List<Furn> furns = fsi.getFurns();
//            //System.out.println(furns);
//            if (furns != null && furns.size() > 0) {
//                System.out.println("成功");
//                req.setAttribute("furns", furns);
//                req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req, resp);
//            }
//        } else if ("add".equals(action)) {
//            //向数据库中加入家具信息
//            String name = req.getParameter("name");
//            name = new String(name.getBytes("iso8859-1"), "utf-8");
//            String maker = req.getParameter("maker");
//            maker = new String(maker.getBytes("iso8859-1"), "utf-8");
//            String price = req.getParameter("price");
//            String sales = req.getParameter("sales");
//            String stock = req.getParameter("stock");
//            BigDecimal price2 = new BigDecimal(price);
//            Integer sale = Integer.parseInt(sales);
//            Integer stock2 = Integer.parseInt(stock);
//            System.out.println(name + " " + maker + " " + price2 + " " + sales + " " + stock2);
//            Furn furn = new Furn(null, name, maker, price2, sale, stock2, null);
//            if (fsi.addFurn(furn)) {
//                System.out.println("添加家具成功");
//            } else {
//                System.out.println("添加家具失败！！！");
//            }
//        }
//    }
}
