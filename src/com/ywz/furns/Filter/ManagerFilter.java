package com.ywz.furns.Filter;

import com.ywz.furns.bean.Manger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 于汶泽
 */
public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Manger manage = (Manger) req.getSession().getAttribute("manage");
        String uri = req.getRequestURI();
        if(uri.endsWith("views/manage/manage_login.jsp")){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        if(manage==null){
            req.getRequestDispatcher("/views/manage/manage_login.jsp").forward(req,servletResponse);
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
