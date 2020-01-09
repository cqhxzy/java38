package com.wisezone.biz;

import com.wisezone.entity.Author;
import com.wisezone.vo.AuthorVo;

public interface AuthorBiz extends CommonBiz<Author> {
    /**
     * 登录
     * @param loginAccount
     * @param loginPwd
     * @return
     */
    AuthorVo login(String loginAccount, String loginPwd);
}
