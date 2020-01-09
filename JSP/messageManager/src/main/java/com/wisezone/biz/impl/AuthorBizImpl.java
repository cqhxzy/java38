package com.wisezone.biz.impl;

import com.wisezone.biz.AuthorBiz;
import com.wisezone.dao.AuthorDao;
import com.wisezone.dao.impl.AuthorDaoImpl;
import com.wisezone.entity.Author;
import com.wisezone.vo.AuthorVo;

import java.util.List;

public class AuthorBizImpl implements AuthorBiz {
    private AuthorDao authorDao = new AuthorDaoImpl();
    @Override
    public AuthorVo login(String loginAccount, String loginPwd) {
        //不能把密码也返回给用户查看
        Author login = authorDao.login(loginAccount, loginPwd);
        if (login == null) return null;
        return new AuthorVo(login.getId(),login.getAuthor(),login.getLoginAccount());
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
