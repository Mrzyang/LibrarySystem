package com.zy.dao;

import com.zy.bean.Book;
import org.junit.Test;

import java.sql.SQLException;


public class BookDaoTest {

    @Test
    public void bookUpdate() throws SQLException {
        BookDao bookDao=new BookDao();
        Book book=new Book();
        book.setId(38);
        book.setName("张伟");
        book.setPrice(111);
        book.setAuthor("张伟");
        book.setCateId(1);
        book.setPdate("2015-12-02");
        book.setAddress("tp123");
        bookDao.bookUpdate(book);
    }
}