package com.wisezone.biz.impl;

import com.wisezone.biz.MessageBiz;
import com.wisezone.util.PageUtil;
import com.wisezone.vo.MessageVo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MessageBizImplTest {

    @Test
    public void page() {
        MessageBiz messageBiz = new MessageBizImpl();

        PageUtil<MessageVo> pageUtil = new PageUtil<>();
        pageUtil.setPageIndex(2);

        //分页查询
        messageBiz.page(pageUtil);

        List<MessageVo> data = pageUtil.getData();
        Integer totalPage = pageUtil.getTotalPage();
        Integer pageIndex = pageUtil.getPageIndex();

        System.out.println("总共有" + totalPage + "页");
        System.out.println("当前页码：" + pageIndex);

        data.stream().forEach(System.out::println);
    }
}