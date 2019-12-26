package com.wisezone.dao.impl;

import com.wisezone.dao.JdbcUtil;
import com.wisezone.dao.StudentDao;
import com.wisezone.entity.Student;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class StudentDaoImpl extends JdbcUtil implements StudentDao {
    @Override
    public int insert(Student student) {
        String sql = "insert into student (`name`,loginPwd,gender,phone,address,bornDate) values(?,?,?,?,?,?)";
        Date bornDate = student.getBornDate();
        Timestamp ts = new Timestamp(bornDate.getTime());
        Object[] params = {student.getName(),student.getLoginPwd(),student.getGender(),student.getPhone(),student.getAddress(),ts};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int update(Student student) {
        String sql = "update student set `name`=?,loginPwd=?,gender=?,phone=?,address=?,bornDate=? where studentNo=?";
        Date bornDate = student.getBornDate();
        Timestamp ts = new Timestamp(bornDate.getTime());
        Object[] params = {student.getName(),student.getLoginPwd(),student.getGender(),student.getPhone(),student.getAddress(),ts,student.getStudentNo()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int deleteById(int stuNo) {
        String sql = "delete from student where studentNo=?";
        return super.executeUpdate(sql,stuNo);
    }

    @Override
    public Student findById(int stuNo) {
        String sql = "select studentNo studentNo,name,loginPwd,phone,gender,address,bornDate from student where studentNo = ?";
        List<Student> students = super.executeQuery(Student.class, sql, stuNo);
        return students.size() > 0 ? students.get(0) : null;
    }

    @Override
    public List<Student> queryAll() {
        String sql = "select studentNo studentNo,name,loginPwd,phone,gender,address,bornDate from student";
        return super.executeQuery(Student.class,sql);
    }

    @Override
    public List<Student> queryAllNoScore() {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT t1.*")
                .append(" FROM student t1")
                .append(" LEFT JOIN scores t2")
                .append(" on t1.studentNo = t2.stuNo")
                .append(" WHERE t2.id is NULL");

        return super.executeQuery(Student.class,builder.toString());
    }

    @Override
    public List<Map<String,Object>> queryStudentWithScore() {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT t1.studentNo,t1.`name`,t1.phone,t2.id scoreId,t2.course,t2.score")
                .append(" FROM student t1")
                .append(" INNER JOIN scores t2")
                .append(" on t1.studentNo = t2.stuNo");

        return super.executeQueryMap(builder.toString());
    }

    @Override
    public int deleteAllInfo(int stuNo) {
        super.startTransaction();
        String delete_score_sql = "delete from scores where stuNo = ?";
        String delete_student_sql = "delete from student where studentno = ?";

        return 0;
    }
}
