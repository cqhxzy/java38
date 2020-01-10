package com.wisezone.biz.impl;

import com.wisezone.biz.MessageBiz;
import com.wisezone.dao.MessageDao;
import com.wisezone.dao.impl.MessageDaoImpl;
import com.wisezone.entity.Message;
import com.wisezone.util.ConverterUtil;
import com.wisezone.util.PageUtil;
import com.wisezone.vo.MessageVo;

import java.util.List;
import java.util.stream.Collectors;

public class MessageBizImpl implements MessageBiz {
    private MessageDao messageDao = new MessageDaoImpl();
    @Override
    public int insert(Message message) {
        return messageDao.insert(message);
    }

    @Override
    public int update(Message message) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public Message findById(int id) {
        return null;
    }

    @Override
    public List<Message> queryAll() {
        return messageDao.queryAll();
    }

    @Override
    public List<MessageVo> queryAllMes() {
        List<Message> messages = queryAll();
        return messages.stream().map(t -> {
            MessageVo vo = new MessageVo();
            vo.setId(t.getId());
            vo.setTopic(t.getTopic());
            vo.setContent(t.getContent());
            vo.setMesDate(ConverterUtil.date2String(t.getMesDate()));
            vo.setAuthroId(t.getAuthor().getId());
            vo.setAuthor(t.getAuthor().getAuthor());
            return vo;
        }).collect(Collectors.toList());
    }

    @Override
    public void page(PageUtil pageUtil) {
        messageDao.page(pageUtil);
    }


}
