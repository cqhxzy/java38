package test3;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 负责对学生进行向数据的DML操作
 */
public class StudentService extends JdbcUtil{
    /**
     * 负责向数据库插入学生信息
     * @param student
     * @return
     */
    public int insert(Student student){
        //插入学生表的sql
        String sql = "insert into student (`name`,loginPwd,gender,phone,address,bornDate) values(?,?,?,?,?,?)";
        Date bornDate = student.getBornDate();
        Timestamp ts = new Timestamp(bornDate.getTime());
        Object[] params = {student.getName(),student.getLoginPwd(),student.getGender(),student.getPhone(),student.getAddress(),ts};
        return super.executeUpdate(sql, params);
    }

    /**
     * 根据学号修改学生信息
     * @param student
     * @return
     */
    public int updateById(Student student){
        String sql = "update student set `name`=?,loginPwd=?,gender=?,phone=?,address=?,bornDate=? where studentNo=?";
        Date bornDate = student.getBornDate();
        Timestamp ts = new Timestamp(bornDate.getTime());
        Object[] params = {student.getName(),student.getLoginPwd(),student.getGender(),student.getPhone(),student.getAddress(),ts,student.getStudentNo()};

        return super.executeUpdate(sql,params);
    }

    /**
     * 根据学号做删除
     * @return
     */
    public int deleteById(int studentNo){
        String sql = "delete from student where studentNo=?";
        return super.executeUpdate(sql,studentNo);
    }

    public List<Student> queryAll(){
        String sql = "select studentNo studentNo,name,loginPwd,phone,gender,address,bornDate from student";
        List<Student> students = super.executeQuery(Student.class, sql);
        return students;
    }
}
