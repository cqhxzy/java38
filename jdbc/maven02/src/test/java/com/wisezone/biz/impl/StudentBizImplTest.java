package com.wisezone.biz.impl;

import com.wisezone.biz.StudentBiz;
import com.wisezone.entity.Student;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class StudentBizImplTest {

    @Test
    public void insert() {
        StudentBiz studentBiz = new StudentBizImpl();
        int insert = studentBiz.insert(new Student(0, "张三丰", "123456", "男", null, null, new Date()));
        assertThat(insert, greaterThan(0)); //只要结果大于0则插入成功
    }
}