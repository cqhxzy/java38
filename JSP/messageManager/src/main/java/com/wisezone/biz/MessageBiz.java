package com.wisezone.biz;

import com.wisezone.entity.Message;
import com.wisezone.util.PageUtil;
import com.wisezone.vo.MessageVo;

import java.util.List;

public interface MessageBiz extends CommonBiz<Message> {
    List<MessageVo> queryAllMes();

    /**
     * 分页查询
     * @param pageUtil
     */
    void page(PageUtil pageUtil);
}
