package com.zy.servlet;



import com.zy.dao.UserDao;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="LoginServlet", urlPatterns={"/login.do"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  username= request.getParameter("username");
        String  password= request.getParameter("password");
        String checkcode=request.getParameter("checkcode");
        HttpSession session=request.getSession();
        String code= (String) session.getAttribute("verCode");
        Map map=new HashMap();
        map.put("status","0");
        map.put("data","登录失败");
        if(code.equals(checkcode)){
            UserDao userDao=new UserDao();
            try {
                if(userDao.isRegistered(username,password))
                    map.put("status","1");
                    map.put("data","登录成功！");
                    session.setAttribute("username",username);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        JSONObject msg=JSONObject.fromObject(map);
        System.out.println(msg);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        out.println(msg);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type=request.getParameter("type");
        if(type.equals("logout")){
            HttpSession session=request.getSession();
            session.removeAttribute("username");
            response.sendRedirect("/login.jsp");
        }
    }
}
