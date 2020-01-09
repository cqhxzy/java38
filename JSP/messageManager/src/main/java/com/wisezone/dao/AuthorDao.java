package com.wisezone.dao;

import com.wisezone.entity.Author;

public interface AuthorDao extends CommonDao<Author> {

    /**
     * 登录
     * @param loginAccount
     * @param loginPwd
     * @return
     */
    Author login(String loginAccount,String loginPwd);
}
