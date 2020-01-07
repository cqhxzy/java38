package com.wisezone.biz.impl;

import com.wisezone.biz.HandSetBiz;
import com.wisezone.dao.HandSetDao;
import com.wisezone.dao.impl.HandSetDaoImpl;
import com.wisezone.entity.HandSet;

import java.util.List;

public class HandSetBizImpl implements HandSetBiz {

    //引用数据访问层
    private HandSetDao handSetDao = new HandSetDaoImpl();

    @Override
    public int insert(HandSet handSet) {
        return handSetDao.insert(handSet);
    }

    @Override
    public int update(HandSet handSet) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return handSetDao.deleteById(id);
    }

    @Override
    public HandSet findById(int id) {
        return handSetDao.findById(id);
    }

    @Override
    public List<HandSet> queryAll() {
        return handSetDao.queryAll();
    }
}
