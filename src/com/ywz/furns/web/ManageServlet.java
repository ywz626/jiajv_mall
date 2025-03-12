package com.ywz.furns.web;

import com.ywz.furns.bean.Manger;
import com.ywz.furns.service.MangerService;
import com.ywz.furns.service.impl.MangerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 于汶泽
 */
public class ManageServlet extends BasicServlet {
    private MangerService manger = new MangerServiceImpl();
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String upwd = req.getParameter("password");
        Manger manage = manger.checkPwd(uname,upwd);
        if (manage!= null) {
            req.getRequestDispatcher("/views/manage/manage_menu.jsp").forward(req,resp);
            return;
        }else {
            req.getRequestDispatcher("/views/manage/manage_login.jsp").forward(req,resp);
            return;
        }
    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String uname = req.getParameter("username");
//        String upwd = req.getParameter("password");
//        Manger manage = manger.checkPwd(uname,upwd);
//        if (manage!= null) {
//            req.getRequestDispatcher("/views/manage/manage_menu.jsp").forward(req,resp);
//        }else {
//            req.getRequestDispatcher("/views/manage/manage_login.jsp").forward(req,resp);
//        }
//    }
}
