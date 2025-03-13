package com.ywz.furns.web;

import com.ywz.furns.bean.User;
import com.ywz.furns.service.UserService;
import com.ywz.furns.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author 于汶泽
 */
public class UserServlet extends BasicServlet {
    private UserService userService = new UserServiceImpl();

    //用户登录的逻辑
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String uname = req.getParameter("user-name");
        String upwd = req.getParameter("user-password");
        User user = userService.checkPwd(uname, upwd);
        if (user != null) {
            //System.out.println("登陆成功！！！");
            session.setAttribute("user",user);
            req.getRequestDispatcher("/views/member/login_ok.jsp").forward(req, resp);
            return;
        } else {
            //System.out.println("登陆失败！！！");
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", uname);
            req.getRequestDispatcher("/views/member/login.jsp").forward(req, resp);
            return;
        }
    }

    //注册用户逻辑
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String uname = req.getParameter("user-name");
        String upwd = req.getParameter("user-password");
        String userEmail = req.getParameter("user-email");
        User user = new User(uname, upwd, userEmail);
        String code = req.getParameter("code");
        String token = (String) session.getAttribute(KAPTCHA_SESSION_KEY);
        session.removeAttribute(token);
        //System.out.println(user);
        if (!code.equalsIgnoreCase(token)) {
            req.setAttribute("active","register");
            req.setAttribute("msg", "验证码输入错误");
            req.setAttribute("uname",uname);
            req.setAttribute("upwd",upwd);
            req.setAttribute("email",userEmail);
            req.getRequestDispatcher("/views/member/login.jsp").forward(req, resp);
            return;
        }
        if (!userService.isUsernameExist(uname)) {
            userService.login(user);
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/views/member/register_ok.html").forward(req, resp);
        } else {
            System.out.println("用户名被占用");
            req.getRequestDispatcher("/views/member/register_fail.html").forward(req, resp);
        }
    }

    public void exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
    //老代码，使用if else 流程控制判断请求是登录还是注册用户
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        String uname = req.getParameter("user-name");
//        String upwd = req.getParameter("user-password");
//        if("login".equals(action)) {
//            User user = userService.checkPwd(uname, upwd);
//            if(user!=null) {
//                //System.out.println("登陆成功！！！");
//                req.getRequestDispatcher("/views/member/login_ok.jsp").forward(req,resp);
//            }else {
//                //System.out.println("登陆失败！！！");
//                req.setAttribute("msg","用户名或密码错误");
//                req.setAttribute("username",uname);
//                req.getRequestDispatcher("/views/member/login.jsp").forward(req,resp);
//            }
//        }else {
//            String userEmail = req.getParameter("user-email");
//            User user = new User(uname,upwd, userEmail);
//            System.out.println(user);
//            if (!userService.isUsernameExist(uname)) {
//                userService.login(user);
//                req.getRequestDispatcher("/views/member/register_ok.html").forward(req, resp);
//            }else {
//                System.out.println("用户名被占用");
//                req.getRequestDispatcher("/views/member/register_fail.html").forward(req,resp);
//            }
//        }
//
//    }
}
