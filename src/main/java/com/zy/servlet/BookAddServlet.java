package com.zy.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.zy.bean.Book;
import com.zy.dao.BookDao;
import net.sf.json.JSONObject;

@WebServlet(name = "BookAddServlet",urlPatterns={"/bookadd"})
@MultipartConfig(
        maxFileSize = 5*1024*1024
)
public class BookAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        request.setCharacterEncoding("UTF-8");
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
        fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileName;
        System.out.println(fileName);
        String relativePath = "/assets/bookicon/";      //图片上传到Tomcat相对本项目的路径
        String basePath = request.getSession().getServletContext().getRealPath("");  //项目根目录
        //System.out.println(basePath);
        String absolutePath=basePath+relativePath+fileName; //保存在服务器绝对路径
       // System.out.println(absolutePath);
        //上传文件到部署路劲
        part.write(absolutePath);
        String img=relativePath+fileName;

        //添加进数据库
        Book book=new Book(0,bookname,price,author,cateId,pdate,img,description,detail,address);
        BookDao bookDao=new BookDao();
        Map map=new HashMap();
        map.put("status","0");
        map.put("data","添加失败");
        try {
            if(bookDao.bookAdd(book))
                map.put("status","1");
                map.put("data","添加成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JSONObject msg=JSONObject.fromObject(map);
        System.out.println(msg);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        out.println(msg);

        //String basePath = getServletContext().getRealPath("/");
        //        // String absolutePath = basePath + "assets\\bookicon\\"+fileName;
        //        //将路径存在session中方便下面显示是用
        request.getSession().setAttribute("PIC", absolutePath);
    }
}
