package com.zy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.zy.bean.Book;
import com.zy.dao.BookDao;
import net.sf.json.JSONObject;

@WebServlet(name = "BookServlet",urlPatterns={"/book.do"})
@MultipartConfig(
        maxFileSize = 5*1024*1024
)
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String type=request.getParameter("type");
        if (type.equals("add")||type.equals("update")) {
            try {
                addOrUpdate(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String type=request.getParameter("type");
        if (type.equals("show")) {
            try {
                showBooks(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (type.equals("delete")) {
            try {
                deleteBook(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (type.equals("batchDel")) {
            try {
                deleteManyBooks(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (type.equals("update")) {
            try {
                updatePage(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //删除单本书
    public void deleteBook(HttpServletRequest request,HttpServletResponse response)throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        BookDao bookDao=new BookDao();
        bookDao.deleteById(id);

    }
    public void updatePage(HttpServletRequest request,HttpServletResponse response)throws Exception{
        int id= Integer.parseInt(request.getParameter("id"));
        BookDao bookDao=new BookDao();
        Book book=bookDao.queryBookById(id);
        request.setAttribute("book",book);
        RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
        rd.forward(request,response);

    }
    public void deleteManyBooks(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String idStr=request.getParameter("idStr");
         idStr=idStr.substring(0,idStr.length()-1);
        String[] ids=idStr.split(",");
        int[] bookIds=new int[20];
        for(int i=0;i<ids.length;i++){
            bookIds[i]= Integer.parseInt(ids[i]);
        }
        BookDao bookDao=new BookDao();
        bookDao.deleteMany(bookIds);
    }

    //后台主页显示所有书籍
    public void showBooks(HttpServletRequest request,HttpServletResponse response)throws Exception{
        BookDao bookDao=new BookDao();
        List list=bookDao.queryAllBooks();
        Gson gson=new Gson();
        String json=gson.toJson(list);
        request.setAttribute("books",list);
        RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
        rd.forward(request,response);
    }


    //把添加和更新写在一个方法中
    public void addOrUpdate(HttpServletRequest request,HttpServletResponse response)throws Exception{
        //获取表单数据
        request.setCharacterEncoding("UTF-8");
        String type=request.getParameter("type");   //判断请求业务是add还是update
        System.out.println(type);
        int id=0;   //add业务不需要指定id
        if(type.equals("update")) id= Integer.parseInt(request.getParameter("id")); //update业务需要指定id
        String bookname=request.getParameter("bookname");
        int cateId= Integer.parseInt(request.getParameter("cateId"));
        double price= Double.parseDouble(request.getParameter("price"));
        String author=request.getParameter("author");
        String pdate=request.getParameter("pdate");
        String address=request.getParameter("address");
        String description=request.getParameter("description");
        String detail=request.getParameter("content");

        //上传图片业务处理
        Part part = request.getPart("img");//前台的文件标签的name,若ajax直接提交表单，这里无法获取
        String file = part.getHeader("Content-Disposition");
        //获取文件名
        String fileName = file.substring(file.lastIndexOf("=") + 2, file.length() - 1);
        String img="";
        if(!fileName.equals("")){         //这里判断是否上传了图片
            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileName;  //防止图片重名
            String relativePath = "/assets/bookImg/";      //图片上传到Tomcat相对本项目的路径
            String basePath = request.getSession().getServletContext().getRealPath("");  //项目根目录
            String absolutePath=basePath+relativePath+fileName; //保存在服务器绝对路径
            //上传文件到部署路劲
            part.write(absolutePath);
            img=relativePath+fileName;
        }else{
            img=request.getParameter("formerImg");
        }
        //添加进数据库
        Book book=new Book(id,bookname,price,author,cateId,pdate,img,description,detail,address);
        BookDao bookDao=new BookDao();
        Map map=new HashMap();
        map.put("status","0");
        map.put("data","操作失败");

        try {
            if (type.equals("add")){
                if(bookDao.bookAdd(book)){
                    map.put("status","1");
                    map.put("data","添加成功！");
                }
            }else {
                if(bookDao.bookUpdate(book)){
                    map.put("status","1");
                    map.put("data","修改成功！");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //放回json到前端
        JSONObject msg=JSONObject.fromObject(map);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        out.println(msg);
    }
}