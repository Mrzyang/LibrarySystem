package com.zy.utils;

import org.junit.Test;


public class Md5Test {

    @Test
    public void md5Password() {
        String password="admin";
        String md5=Md5.md5Password(password);
        System.out.println(md5);
    }
}