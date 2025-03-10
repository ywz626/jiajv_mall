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
//public class UserRegisterServlet extends HttpServlet {
//    private UserServiceImpl userServlet = new UserServiceImpl();
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userName = req.getParameter("user-name");
//        String userPwd = req.getParameter("user-pwd");
//        System.out.println(userPwd);
//        String userEmail = req.getParameter("user-email");
//        User user = new User(userName, userPwd, userEmail);
//        System.out.println(user);
//        if (!userServlet.isUsernameExist(userName)) {
//            userServlet.login(user);
//            req.getRequestDispatcher("/views/member/register_ok.html").forward(req, resp);
//        }else {
//            System.out.println("用户名被占用");
//            req.getRequestDispatcher("/views/member/register_fail.html").forward(req,resp);
//        }
//        //System.out.println(userName+" "+userPwd+" "+userEmail);
////        Connection conn = null;
////        PreparedStatement stat = null;
////        ResultSet rs = null;
////        try {
////            conn = jdbcUtil.getConnection();
////            int count = 0;
////            String sql2 = "insert into user(name,pwd,email) values(?,?,?)";
////            stat = conn.prepareStatement(sql2);
////            stat.setString(1, userName);
////            stat.setString(2, userPwd);
////            stat.setString(3, userEmail);
////            count = stat.executeUpdate();
////            System.out.println(count);
////        } catch (SQLException e) {
////            throw new RuntimeException(e);
////        } finally {
////            jdbcUtil.allClose(conn, stat, rs);
////        }
//    }
//}
