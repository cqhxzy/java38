package com.wisezone.test;

import com.wisezone.biz.StudentBiz;
import com.wisezone.biz.impl.StudentBizImpl;
import com.wisezone.entity.Student;
import com.wisezone.vo.StudentScoreVo;

import java.util.Date;
import java.util.List;

public class StudentBizTest {
    public static void main(String[] args) {
        //在UI层中引用业务逻辑层
        StudentBiz studentBiz = new StudentBizImpl();

        //insertStudent(studentBiz);
        //udpateStudent(studentBiz);
        //deleteStudent(studentBiz);

        //findById(studentBiz);

        //queryAll(studentBiz);

        //queryNoScore(studentBiz);
        queryStudentWithScore(studentBiz);
    }

    private static void queryStudentWithScore(StudentBiz studentBiz) {
        List<StudentScoreVo> studentScoreVos = studentBiz.queryStudentWithScore();
        studentScoreVos.stream().forEach(System.out::println);
    }

    private static void queryNoScore(StudentBiz studentBiz) {
        List<Student> students = studentBiz.queryAllNoScore();
        students.stream().forEach(System.out::println);
    }

    private static void queryAll(StudentBiz studentBiz) {
        List<Student> students = studentBiz.queryAll();
        students.stream().forEach(System.out::println);
    }

    private static void findById(StudentBiz studentBiz) {
        Student student = studentBiz.findById(9);
        System.out.println(student);
    }

    private static void deleteStudent(StudentBiz studentBiz) {
        int i = studentBiz.deleteById(10);
        System.out.println(i > 0 ? "成功":"失败");
    }

    private static void udpateStudent(StudentBiz studentBiz) {
        int update = studentBiz.update(new Student(10, "张无忌", "654321", "男", "13288888888", null, new Date()));
        System.out.println(update > 0 ? "修改成功":"修改失败");
    }

    private static void insertStudent(StudentBiz studentBiz) {
        int insert = studentBiz.insert(new Student(0, "张三丰", "123456", "男", null, null, new Date()));

        System.out.println(insert > 0 ? "新增成功":"新增失败");
    }
}
