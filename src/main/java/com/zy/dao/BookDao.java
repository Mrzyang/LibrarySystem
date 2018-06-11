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
    Connection con = null;

    public boolean bookAdd(Book book) {
        boolean isSuccess = false;
        PreparedStatement psmt = null;
        String sql = "insert into book values(null,?,?,?,?,?,?,?,?,?)";
        try {
            con = JdbcUtil.getConnecttion();
            psmt = con.prepareStatement(sql);
            psmt.setString(1, book.getName());
            psmt.setDouble(2, book.getPrice());
            psmt.setString(3, book.getAuthor());
            psmt.setInt(4, book.getCateId());
            psmt.setString(5, book.getPdate());
            psmt.setString(6, book.getImg());
            psmt.setString(7, book.getDescription());
            psmt.setString(8, book.getDetail());
            psmt.setString(9, book.getAddress());
            psmt.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.release(psmt, con);
        }
        return isSuccess;
    }

    public List queryAllBooks() {
        List list = new ArrayList<Book>();
        PreparedStatement psmt = null;
        ResultSet rs = null;
        String sql = "SELECT * from book";
        try {
            con = JdbcUtil.getConnecttion();
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery(sql);
            while (rs.next()) {
                Book book = new Book(
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.release(rs, psmt, con);
        }
        return list;
    }

    public boolean deleteById(int id) {
        boolean isSuccess = false;
        PreparedStatement psmt = null;
        String sql = "delete from book where id=?";
        try {
            con = JdbcUtil.getConnecttion();
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, id);
            psmt.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.release(psmt, con);
        }
        return isSuccess;
    }

    public boolean deleteMany(int[] ids) {
        boolean isSuccess = false;
        PreparedStatement psmt = null;
        String sql = "delete from book where id=?";
        try {
            con = JdbcUtil.getConnecttion();
            psmt = con.prepareStatement(sql);
            for (int id : ids) {
                psmt.setInt(1, id);
                psmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(psmt, con);
        }
        return isSuccess;
    }

    public Book queryBookById(int id){
        PreparedStatement psmt=null;
        ResultSet rs=null;
        String sql = "SELECT * FROM book where id=?";
        try {
            con = JdbcUtil.getConnecttion();
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, id);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Book book = new Book(
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(rs, psmt, con);
        }
        return null;
    }

    public boolean bookUpdate(Book book) {
        boolean isSuccess = false;
        con = JdbcUtil.getConnecttion();
        PreparedStatement psmt=null;
        String sql = "UPDATE book set name=?,price=?,author=?,cateId=?,pdate=?,img=?,description=?,detail=?,address=? WHERE id=?";
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, book.getName());
            psmt.setDouble(2, book.getPrice());
            psmt.setString(3, book.getAuthor());
            psmt.setInt(4, book.getCateId());
            psmt.setString(5, book.getPdate());
            psmt.setString(6, book.getImg());
            psmt.setString(7, book.getDescription());
            psmt.setString(8, book.getDetail());
            psmt.setString(9, book.getAddress());
            psmt.setInt(10, book.getId());
            psmt.executeUpdate();
            isSuccess = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(psmt, con);
        }
        return isSuccess;
    }

    //用于分页，startIndex=起始索引，offset=偏移量
    public List<Book> listAllOf(int startIndex, int offset, String sql){
        System.out.println(sql);
        PreparedStatement psmt=null;
        ResultSet rs=null;
        List<Book> books = new ArrayList<>();
        try {
            con = JdbcUtil.getConnecttion();
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, startIndex);
            psmt.setInt(2, offset);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Book book = new Book(
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(rs, psmt, con);
        }
        return books;
    }

    public int counts(String sql) {
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try {
            con = JdbcUtil.getConnecttion();
            psmt = con.prepareStatement(sql);
            rs = psmt.executeQuery();
            while (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(rs, psmt, con);
        }
        return 0;
    }

    //分页显示所有的书籍
    public List<Book> getAllBooks(int startIndex, int offset){
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * from book limit ?,?";
        books = listAllOf(startIndex, offset, sql);
        return books;
    }
}
