package com.wisezone.biz.impl;

import com.wisezone.biz.HandSetBiz;
import com.wisezone.entity.HandSet;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class HandSetBizImplTest {

    private HandSetBiz handSetBiz;

    @Before
    public void init(){
        handSetBiz = new HandSetBizImpl();
    }

    @Test
    public void insert() {
        HandSet handSet = new HandSet(0, "nametype", 3333, "networkmode", "networktype", "facade", "screensize", "feelscreen");

        int insert = handSetBiz.insert(handSet);
        assertThat(insert, greaterThan(0));
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
        int i = handSetBiz.deleteById(4);
        assertThat(i, greaterThan(0));
    }

    @Test
    public void findById() {
        HandSet byId = handSetBiz.findById(1);
        assertThat(byId, notNullValue());
        System.out.println(byId);
    }

    @Test
    public void queryAll() {
        List<HandSet> handSets = handSetBiz.queryAll();
        assertThat(handSets.size(), greaterThan(0));
        handSets.stream().forEach(System.out::println);
    }
}