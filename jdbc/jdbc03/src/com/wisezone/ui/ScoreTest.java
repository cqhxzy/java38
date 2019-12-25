package com.wisezone.ui;

import com.wisezone.biz.ScoreBiz;
import com.wisezone.biz.impl.ScoreBizImpl;
import com.wisezone.entity.Score;

import java.util.List;

public class ScoreTest {
    public static void main(String[] args) {
        ScoreBiz scoreBiz = new ScoreBizImpl();
        List<Score> scores = scoreBiz.queryAll();

        scores.stream().forEach(System.out::println);
    }
}
