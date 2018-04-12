package com.zy.UserJdbc.servlet;

import com.google.gson.Gson;
import com.zy.UserJdbc.dao.StudentDao;
import com.zy.UserJdbc.domain.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("dopost方法执行了");
        String type="";
        request.setCharacterEncoding("UTF-8");
        if(request.getParameter("type")!=null){
            type=request.getParameter("type");
        }
        System.out.println(type);
        if(type.equals("new"))
            try{
            insertStudent(request,response);
            }catch (Exception e){
            e.printStackTrace();
            }
            else {
                try{
                    queryAllStudents(request,response);
                }catch (Exception e){
                    e.printStackTrace();
                }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }

    private void insertStudent(HttpServletRequest req,HttpServletResponse resp)throws Exception{
        Long sno=Long.parseLong(req.getParameter("Sno"));
        System.out.println(sno);
        String sname=req.getParameter("Sname");
        String sphone=req.getParameter("Sphone");
        String saddr=req.getParameter("Saddr");
        Short sgender=Short.parseShort(req.getParameter("Sgender"));
        Long sdeptNo=Long.parseLong(req.getParameter("SdeptNo"));
        StudentDao dao=new StudentDao();
        Student stu=new Student();
        stu.setSno(sno);
        stu.setSname(sname);
        stu.setSphone(sphone);
        stu.setSaddr(saddr);
        stu.setSgender(sgender);
        stu.setSdeptNo(sdeptNo);
        dao.insertStudent(stu);
        this.queryAllStudents(req,resp);
    }
    private void queryAllStudents(HttpServletRequest req,HttpServletResponse resp)throws Exception{
        System.out.println("跳转前");
        StudentDao dao=new StudentDao();
        List list=dao.queryAllStudents();
        Gson gson=new Gson();
        String json=gson.toJson(list);
        System.out.println("查询结果为:"+json);
        req.setAttribute("students",list);
        req.setAttribute("aaa","zhangyang");
        RequestDispatcher rd=req.getRequestDispatcher("user/ShowStudents.jsp");
        rd.forward(req,resp);
        System.out.println("跳转后");
    }
}
