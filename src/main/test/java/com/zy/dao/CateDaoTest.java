package com.zy.dao;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class CateDaoTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void queryNameById() throws SQLException {
        CateDao cateDao=new CateDao();
        String catename=cateDao.queryNameById(3);
        System.out.println(catename);
    }
}