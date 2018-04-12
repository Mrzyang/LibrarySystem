package com.zy.UserJdbc.dao;

import com.zy.UserJdbc.domain.Department;
import com.zy.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    public Connection con;
    public List queryAllDepartments() throws SQLException {
        List<Department> list=new ArrayList();
        con= JdbcUtil.getConnecttion();
        String sql="select * from departments";
        try {
            PreparedStatement pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                Department depart=new Department();
                depart.setDno(rs.getLong(1));
                depart.setDname(rs.getString(2));
                list.add(depart);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            con.close();
        }
        return list;

    }
}
