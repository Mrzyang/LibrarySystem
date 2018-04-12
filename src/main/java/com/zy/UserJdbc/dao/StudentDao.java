package com.zy.UserJdbc.dao;

import com.zy.UserJdbc.domain.Student;
import com.zy.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private Connection con;
    public boolean insertStudent(Student stu)throws Exception{
        boolean isSuccess=false;
        con=JdbcUtil.getConnecttion();
        String sql="insert into students values(?,?,?,?,?,?)";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setLong(1,stu.getSno());
            pst.setString(2,stu.getSname());
            pst.setString(3,stu.getSphone());
            pst.setString(4,stu.getSaddr());
            pst.setShort(5,stu.getSgender());
            pst.setLong(6,stu.getSdeptNo());
            pst.executeUpdate();
            isSuccess=true;
        }catch (SQLException e){
            con.rollback();
            e.printStackTrace();
        }finally {
            con.close();
        }
        return isSuccess;
    }

    public List queryAllStudents() throws Exception{
        List<Student> list=new ArrayList();
        con=JdbcUtil.getConnecttion();
        String sql="select * from students";
        try{
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                Student stu=new Student();
                stu.setSno(rs.getLong(1));
                stu.setSname(rs.getString(2));
                stu.setSphone(rs.getString(3));
                stu.setSaddr(rs.getString(4));
                stu.setSgender(rs.getShort(5));
                stu.setSdeptNo(rs.getLong(6));
                list.add(stu);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            con.close();
        }
        return list;

    }
}

