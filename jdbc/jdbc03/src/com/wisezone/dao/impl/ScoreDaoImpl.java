package com.wisezone.dao.impl;

import com.wisezone.dao.JdbcUtil;
import com.wisezone.dao.ScoreDao;
import com.wisezone.entity.Score;

import java.util.List;

public class ScoreDaoImpl extends JdbcUtil implements ScoreDao {
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
        String sql = "select id,course,score,stuNo student from scores";
        return super.executeQuery(Score.class, sql);
    }
}
