package com.zy.dao;

import com.zy.utils.JdbcUtil;
import com.zy.utils.Md5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection con;
    public boolean isRegistered(String username,String password) throws SQLException {
        boolean IsRegistered=false;
        password= Md5.md5Password(password);
        con= JdbcUtil.getConnecttion();
        String sql="SELECT * FROM user WHERE username=? and password=?";
        try{
            PreparedStatement psmt=con.prepareStatement(sql);
            psmt.setString(1,username);
            psmt.setString(2,password);
            ResultSet rs=psmt.executeQuery();
            System.out.println(rs);
            while(rs.next()){
                System.out.println(rs.getString(2)+"\t"+rs.getString(3));
                IsRegistered=true;
            }

        }catch (SQLException e){
            con.rollback();
            e.printStackTrace();
        }finally {
            con.close();
        }
        return IsRegistered;
    }
}
