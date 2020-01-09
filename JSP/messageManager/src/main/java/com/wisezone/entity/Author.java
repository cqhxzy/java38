package com.wisezone.entity;

public class Author {
    private Integer id;
    private String author;
    private String loginAccount;
    private String loginPwd;

    public Author() {
    }

    public Author(Integer id, String author, String loginAccount, String loginPwd) {
        this.id = id;
        this.author = author;
        this.loginAccount = loginAccount;
        this.loginPwd = loginPwd;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }
}
