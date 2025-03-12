package com.ywz.furns.web;

import com.ywz.furns.Utils.DbUtils;
import com.ywz.furns.bean.Furn;
import com.ywz.furns.bean.Page;
import com.ywz.furns.service.FurnsService;
import com.ywz.furns.service.impl.FurnsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 于汶泽
 */
@WebServlet(name = "CustomerFurnServlet",
        urlPatterns="/customerServlet")
public class CustomerFurnServlet extends BasicServlet{
    private FurnsService fsi = new FurnsServiceImpl();
    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = DbUtils.getInt(request.getParameter("pageNo"),1);
        int pageSize = DbUtils.getInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Furn> page = fsi.getPage(pageNo, pageSize);
        //List<Furn> dataList = page.getDataList();
//        for (Furn furn:dataList){
//            System.out.println(furn);
//        }
        String action = request.getParameter("action");
        request.setAttribute("page",page);
        request.setAttribute("action",action);
        request.getRequestDispatcher("/views/customer/index.jsp").forward(request, response);
        }
        public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");
            if(name == null) {
                name = "";
            }
            int pageNo = DbUtils.getInt(request.getParameter("pageNo"),1);
            int pageSize = DbUtils.getInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
            Page<Furn> page = fsi.getPage(name, pageNo, pageSize);
            String action = request.getParameter("action");
            request.setAttribute("name",name);
            request.setAttribute("page",page);
            request.setAttribute("action",action);
            request.getRequestDispatcher("/views/customer/index.jsp").forward(request, response);
        }
    }