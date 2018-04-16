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
    public List queryAllCates() throws SQLException {
        con= JdbcUtil.getConnecttion();
        List<Cate> list=new ArrayList<Cate>();
        String sql="select * from cate";
        PreparedStatement psmt=con.prepareStatement(sql);
        ResultSet rs=psmt.executeQuery();
        while(rs.next()){
            Cate cate=new Cate();
            cate.setId(rs.getInt(1));
            cate.setName(rs.getString(2));
            list.add(cate);
        }
        JdbcUtil.release(rs,psmt,con);
        return list;
    }
    public  String queryNameById(int id) throws SQLException {
        con=JdbcUtil.getConnecttion();
        String sql="SELECT * from cate WHERE id=?";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setInt(1,id);
        ResultSet rs=psmt.executeQuery();
        while (rs.next()){
            String name=rs.getString(2);
            JdbcUtil.release(rs,psmt,con);
            return name;
        }
        return null;
    }
}
