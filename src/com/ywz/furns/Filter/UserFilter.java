package com.ywz.furns.Filter;

import com.ywz.furns.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 于汶泽
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User user = (User) request.getSession().getAttribute("user");
        String uri = request.getRequestURI();
        if(uri.endsWith("views/member/login.jsp")){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        if (user == null) {
            request.getRequestDispatcher("/views/member/login.jsp").forward(request, servletResponse);
        }else {
            filterChain.doFilter(request, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
