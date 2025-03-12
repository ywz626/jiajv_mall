package com.ywz.furns.web;

import com.ywz.furns.Utils.DbUtils;
import com.ywz.furns.bean.Furn;
import com.ywz.furns.bean.Page;
import com.ywz.furns.service.impl.FurnsServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 于汶泽
 */
public class FurnServlet extends BasicServlet {
    private FurnsServiceImpl fsi = new FurnsServiceImpl();

    //
    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = DbUtils.getInt(request.getParameter("pageNo"), 1);
        int pageSize = DbUtils.getInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Furn> page = fsi.getPage(pageNo, pageSize);
        List<Furn> dataList = page.getDataList();
//        for (Furn furn : dataList) {
//            System.out.println(furn);
//        }
        request.setAttribute("page",page);
        request.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(request, response);
        return;
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Furn> furns = fsi.getFurns();
        //System.out.println(furns);
        if (furns != null && furns.size() > 0) {
           // System.out.println("成功");
            req.setAttribute("furns", furns);
            req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req, resp);
            return;
        }
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        //name = new String(name.getBytes("iso8859-1"), "utf-8");
//        String maker = req.getParameter("maker");
//        //maker = new String(maker.getBytes("iso8859-1"), "utf-8");
//        String price = req.getParameter("price");
//        String sales = req.getParameter("sales");
//        String stock = req.getParameter("stock");
//        BigDecimal price2 = new BigDecimal(price);
//        Integer sale = Integer.parseInt(sales);
//        Integer stock2 = Integer.parseInt(stock);
//        System.out.println(name + " " + maker + " " + price2 + " " + sales + " " + stock2);
//        Furn furn = new Furn(null, name, maker, price2, sale, stock2, null);
        Map<String, String[]> furns = req.getParameterMap();
        Furn furn = new Furn();
        try {
            BeanUtils.populate(furn,furns);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        if (fsi.addFurn(furn)) {
            System.out.println("添加家具成功");
            resp.sendRedirect("/jiajv/manage/FurnServlet?action=login");
            return;
            //请求转发会造成刷新页面时重复提交数据，使用重定向解决
            //req.getRequestDispatcher("/manage/FurnServlet?action=login").forward(req,resp);
        } else {
            System.out.println("添加家具失败！！！");
        }
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Furn furn = new Furn();
        String pageNo = req.getParameter("pageNo");
        try{
            BeanUtils.populate(furn,req.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        if (fsi.deleteFurn(furn)) {
            System.out.println(furn.getName()+"删除成功");
            resp.sendRedirect(req.getContextPath()+"/manage/FurnServlet?action=page&pageNo="+pageNo);
        }else {
            System.out.println(furn.getName() + "删除失败");
        }
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Furn furn = new Furn();
        Map<String, String[]> parameterMap = req.getParameterMap();
        String pageNo = req.getParameter("pageNo");
        System.out.println("=======================");
        for (String key : parameterMap.keySet()){
            System.out.println(key);
        }
        try {
            BeanUtils.populate(furn,req.getParameterMap());
        }catch (Exception e){
            e.printStackTrace();
        }
        if(fsi.updateFurn(furn)){
            System.out.println(furn.getName()+"更新成功");
            resp.sendRedirect(req.getContextPath()+"/manage/FurnServlet?action=page&pageNo="+pageNo);
        } else {
            System.out.println("更新失败");
        }
    }
    public void showFurn(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String id = req.getParameter("id");
        Furn furn = fsi.getFurnById(Integer.parseInt(id));
        System.out.println(furn);
        String pageNo = req.getParameter("pageNo");
        req.setAttribute("furn",furn);
        req.setAttribute("pageNo",pageNo);
        req.getRequestDispatcher("/views/manage/furn_update.jsp?pageNo="+pageNo).forward(req, resp);
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
