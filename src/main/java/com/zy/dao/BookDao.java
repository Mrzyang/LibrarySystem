package com.zy.dao;

import com.zy.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List queryAllBooks() throws SQLException {
        List list=new ArrayList<Book>();
        con=JdbcUtil.getConnecttion();
        String sql="SELECT * from book";
        PreparedStatement psmt=con.prepareStatement(sql);
        ResultSet rs=psmt.executeQuery(sql);
        while (rs.next()){
            Book book=new Book(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10)
                    );
            list.add(book);
        }
        return list;
    }
    public boolean deleteById(int id) throws SQLException {
        boolean isSuccess=false;
        con=JdbcUtil.getConnecttion();
        String sql="delete from book where id=?";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setInt(1,id);
        psmt.executeUpdate();
        isSuccess=true;
        return isSuccess;
    }
    public boolean deleteMany(int[] ids) throws SQLException {
        boolean isSuccess=false;
        con=JdbcUtil.getConnecttion();
        String sql="delete from book where id=?";
        PreparedStatement psmt=con.prepareStatement(sql);
        for (int id: ids) {
            psmt.setInt(1,id);
            psmt.executeUpdate();
        }
        return isSuccess;
    }
    public Book queryBookById(int id) throws SQLException {
        con=JdbcUtil.getConnecttion();
        String sql="SELECT * FROM book where id=?";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setInt(1,id);
        ResultSet rs=psmt.executeQuery();
        while(rs.next()){
            Book book=new Book(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10)
            );
            return book;
        }
        return null;
    }

    public boolean bookUpdate(Book book) throws SQLException {
        boolean isSuccess=false;
        con= JdbcUtil.getConnecttion();
        String sql="UPDATE book set name=?,price=?,author=?,cateId=?,pdate=?,img=?,description=?,detail=?,address=? WHERE id=?";
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
        psmt.setInt(10,book.getId());
        psmt.executeUpdate();
        isSuccess=true;
        return isSuccess;
    }
    //用于分页，startIndex=起始索引，offset=偏移量
    public List<Book> listAllOf(int startIndex, int offset,String sql) throws SQLException {
        List<Book> books=new ArrayList<>();
        con=JdbcUtil.getConnecttion();
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setInt(1,startIndex);
        psmt.setInt(2,offset);
        ResultSet rs=psmt.executeQuery();
        while(rs.next()){
            Book book=new Book(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10)
            );
            books.add(book);
        }
        return books;
    }
    public int counts() throws SQLException {
        con=JdbcUtil.getConnecttion();
        String sql="select count(*) from book";
        PreparedStatement psmt=con.prepareStatement(sql);
        ResultSet rs= psmt.executeQuery();
        while(rs.next()) return rs.getInt(1);
        return 0;
    }
    //分页显示所有的书籍
    public List<Book> getAllBooks(int startIndex, int offset) throws SQLException {
        List<Book> books=new ArrayList<>();
        String sql="SELECT * from book limit ?,?";
        books=listAllOf(startIndex,offset,sql);
        return books;
    }
}
