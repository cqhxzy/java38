package com.wisezone.dao.impl;

import com.wisezone.dao.AuthorDao;
import com.wisezone.dao.JdbcUtil;
import com.wisezone.entity.Author;

import java.util.List;

public class AuthorDaoImpl extends JdbcUtil implements AuthorDao {
    @Override
    public Author login(String loginAccount, String loginPwd) {
        String sql = "select * from author where loginAccount=? and loginPwd=?";
        List<Author> authors = super.executeQuery(Author.class, sql, loginAccount, loginPwd);
        return authors.size() > 0 ? authors.get(0) : null;
    }

    @Override
    public int insert(Author author) {
        return 0;
    }

    @Override
    public int update(Author author) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public Author findById(int id) {
        return null;
    }

    @Override
    public List<Author> queryAll() {
        return null;
    }
}
