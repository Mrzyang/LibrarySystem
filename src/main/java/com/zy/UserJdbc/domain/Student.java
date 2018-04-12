package com.zy.UserJdbc.domain;

public class Student {
    private Long Sno;
    private String Sname;
    private String Sphone;
    private String Saddr;
    private Short Sgender;
    private Long SdeptNo;

    public Long getSno() {
        return Sno;
    }

    public void setSno(Long sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSphone() {
        return Sphone;
    }

    public void setSphone(String sphone) {
        Sphone = sphone;
    }

    public String getSaddr() {
        return Saddr;
    }

    public void setSaddr(String saddr) {
        Saddr = saddr;
    }

    public Short getSgender() {
        return Sgender;
    }

    public void setSgender(Short sgender) {
        Sgender = sgender;
    }

    public Long getSdeptNo() {
        return SdeptNo;
    }

    public void setSdeptNo(Long sdeptNo) {
        SdeptNo = sdeptNo;
    }


}
