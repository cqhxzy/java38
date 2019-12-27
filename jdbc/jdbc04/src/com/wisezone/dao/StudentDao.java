package com.wisezone.dao;

import com.wisezone.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * 对学生表做增、删、改、查的接口
 */
public interface StudentDao extends CommonDao<Student>{
    /**
     * 查询缺考的学生信息
     * @return
     */
    List<Student> queryAllNoScore();

    /**
     * 查询有成绩的学生信息
     * @return
     */
    List<Map<String,Object>> queryStudentWithScore();

    int deleteAllInfo(int stuNo);
}
