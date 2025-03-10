//package com.ywz.furns.web;
//
//import com.ywz.furns.bean.User;
//import com.ywz.furns.service.impl.UserServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author 于汶泽
// */
//public class UserLoginServlet extends HttpServlet {
//    private UserServiceImpl userServlet = new UserServiceImpl();
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String uname = req.getParameter("user-name");
//        String upwd = req.getParameter("user-password");
//        User user = userServlet.checkPwd(uname, upwd);
//        if(user!=null) {
//            System.out.println("登陆成功！！！");
//            req.getRequestDispatcher("/views/member/login_ok.html").forward(req,resp);
//        }else {
//            System.out.println("登陆失败！！！");
//            req.setAttribute("msg","用户名或密码错误");
//            req.setAttribute("username",uname);
//            req.getRequestDispatcher("/views/member/login.jsp").forward(req,resp);
//        }
//    }
//}
