package com.wisezone.dao;

import com.wisezone.entity.Message;
import com.wisezone.util.PageUtil;

import java.util.List;

public interface MessageDao extends CommonDao<Message> {
    /**
     * 分页查询
     * @return
     */
    PageUtil page(PageUtil pageUtil);

    /**
     * 获取总共有多少条数据
     * @return
     */
    int total();
}
