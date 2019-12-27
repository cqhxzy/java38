package com.wisezone.biz;

import com.wisezone.entity.Student;
import com.wisezone.vo.StudentScoreVo;

import java.util.List;

public interface StudentBiz extends CommonBiz<Student>{
    /**
     * 查询缺考的学生信息
     * @return
     */
    List<Student> queryAllNoScore();

    /**
     * 查询有成绩的学生信息
     * @return
     */
    List<StudentScoreVo> queryStudentWithScore();

    int deleteAllInfo(int stuNo);
}
