package test3;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TestStudentSerivce {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        StudentService service = new StudentService();
        //insertStudent(service);

        //updateById(service);

        //deleteById(service);

        List<Student> students = service.queryAll();
        students.stream().forEach(System.out::println);
    }

    private static void deleteById(StudentService service) {
        System.out.println("请输入要删除的学号");
        int stuNo = input.nextInt();
        int deleteById = service.deleteById(stuNo);
        System.out.println(deleteById > 0 ? "删除成功":"删除失败");
    }

    private static void updateById(StudentService service) {
        Student student = new Student(10,"胡旭旭","666666","男","131686868686","重庆市移动互联网学院",new Date());
        int i = service.updateById(student);
        System.out.println(i > 0 ? "修改成功":"修改失败");
    }

    private static void insertStudent(StudentService service) {
        //新增学生
        Student student = new Student(0,"胡晨旭","888888","男","13188888888","重庆市移动互联网学院",new Date());
        int insert = service.insert(student);
        System.out.println(insert > 0 ? "新增成功":"新增失败");
    }
}
