package com.zy.dao;

import com.zy.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.zy.bean.Book;

public class BookDao {
    Connection con=null;
    public boolean bookAdd(Book book) throws SQLException {
        boolean isSuccess=false;
        con= JdbcUtil.getConnecttion();
        String sql="insert into book values(null,?,?,?,?,?,?,?,?,?)";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,book.getName());
        psmt.setDouble(2,book.getPrice());
        psmt.setString(3,book.getAuthor());
        psmt.setInt(4,book.getCateId());
        psmt.setString(5,book.getPdate());
        psmt.setString(6,book.getImg());
        psmt.setString(7,book.getDescription());
        psmt.setString(8,book.getDetail());
        psmt.setString(9,book.getAddress());
        psmt.executeUpdate();
        isSuccess=true;
        return isSuccess;
    }
}
