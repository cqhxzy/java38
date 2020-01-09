package com.wisezone.vo;

public class AuthorVo {
    private Integer id;
    private String author;
    private String loginAccount;

    @Override
    public String toString() {
        return "AuthorVo{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                '}';
    }

    public AuthorVo() {
    }

    public AuthorVo(Integer id, String author, String loginAccount) {
        this.id = id;
        this.author = author;
        this.loginAccount = loginAccount;
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
}
