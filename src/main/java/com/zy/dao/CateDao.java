package com.zy.dao;

import com.zy.bean.Cate;
import com.zy.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CateDao {
    public  Connection con;
    public List queryAllCates(){
        PreparedStatement psmt=null;
        ResultSet rs=null;
        List<Cate> list=new ArrayList<Cate>();
        String sql="select * from cate";
        try {
            con= JdbcUtil.getConnecttion();
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
            while(rs.next()){
                Cate cate=new Cate();
                cate.setId(rs.getInt(1));
                cate.setName(rs.getString(2));
                list.add(cate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(rs,psmt,con);
        }
        return list;
    }
    public  String queryNameById(int id){
        PreparedStatement psmt=null;
        ResultSet rs=null;
        String sql="SELECT * from cate WHERE id=?";
        try {
            con=JdbcUtil.getConnecttion();
            psmt=con.prepareStatement(sql);
            psmt.setInt(1,id);
            rs=psmt.executeQuery();
            while (rs.next()){
                String name=rs.getString(2);
                return name;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(rs,psmt,con);
        }
        return null;
    }
}
