package com.zy.UserJdbc.servlet;

import com.google.gson.Gson;
import com.zy.UserJdbc.dao.DepartmentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDao dao=new DepartmentDao();
        List list=null;
        try{
            list=dao.queryAllDepartments();
        }catch (Exception e){
            e.printStackTrace();
        }
        Gson gson=new Gson();
        String json=gson.toJson(list);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        out.write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
