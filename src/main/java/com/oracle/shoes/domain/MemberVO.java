package com.oracle.shoes.domain;
/*    userId      varchar(15)    not null,
            userPass    varchar(100)   not null,
            userName    varchar(30)    not null,
            userMail    varchar(50)     not null,
            userPhon    varchar(20)    not null,
            userAddr   varchar(140)    not null,
            regiDate    timestamp            default CURRENT_TIMESTAMP(),
        verify      int          default 0,
        */


import java.util.Date;

public class MemberVO {
    private Long userNo;
    private String userId;
    private String userPass;
    private String userName;
    private String userMail;
    private String userPhon;
    private String userAddr;
    private Date regiDate;

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhon() {
        return userPhon;
    }

    public void setUserPhon(String userPhon) {
        this.userPhon = userPhon;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }
}
