package room1;

public class TestStudent2 {
    public static void main(String[] args) {
        Student stu1 = new Student();//实例了一个空的学生对象

        int stuNo = stu1.stuNo;
        String name = stu1.name;
        int age = stu1.age;
        char sex = stu1.sex;
        long phone = stu1.phone;
        String address = stu1.address;
        System.out.println("学号：" + stuNo);
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
        System.out.println("性别：" + sex);
        System.out.println("电话：" + phone);
        System.out.println("地址：" + address);
    }
}
