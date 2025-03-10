package com.ywz.furns.web;

import com.ywz.furns.bean.Furn;
import com.ywz.furns.service.impl.FurnsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 于汶泽
 */
public class FurnServlet extends HttpServlet {
    private FurnsServiceImpl fsi= new FurnsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Furn> furns = fsi.getFurns();
        System.out.println(furns);
        if(furns!=null&&furns.size()>0){
            System.out.println("成功");
            req.setAttribute("furns",furns);
            req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req, resp);
        }
    }
}
