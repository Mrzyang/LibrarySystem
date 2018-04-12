package com.zy.UserJdbc.domain;

public class Department {
    public long getDno() {
        return dno;
    }

    public void setDno(long dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    private long dno;
    private String dname;
}
