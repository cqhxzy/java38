package com.wisezone.biz.impl;

import com.wisezone.biz.ScoreBiz;
import com.wisezone.dao.ScoreDao;
import com.wisezone.dao.impl.ScoreDaoImpl;
import com.wisezone.entity.Score;

import java.util.List;

public class ScoreBizImpl implements ScoreBiz {
    private ScoreDao scoreDao = new ScoreDaoImpl();
    @Override
    public int insert(Score score) {
        return 0;
    }

    @Override
    public int update(Score score) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public Score findById(int id) {
        return null;
    }

    @Override
    public List<Score> queryAll() {
        return scoreDao.queryAll();
    }
}
