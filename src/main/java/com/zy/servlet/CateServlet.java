package com.zy.servlet;

import com.google.gson.Gson;
import com.zy.dao.CateDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CateServlet",urlPatterns={"/cate"})
public class CateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CateDao cateDao=new CateDao();
        List list=null;
        try {
            list=cateDao.queryAllCates();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson=new Gson();
        String json=gson.toJson(list);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        out.write(json);
    }
}
