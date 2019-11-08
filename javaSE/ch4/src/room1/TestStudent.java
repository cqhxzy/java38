package room1;

public class TestStudent {
    public static void main(String[] args) {
        //创建学生的对象
        Student stu1 = new Student();
        //room1.Student@4554617c
        //Student代表类型 @ 4554617c对应的内存空间中
        System.out.println(stu1);

        //在java中，通过对象名.属性或对象名.方法的形式调用属性和方法
        stu1.stuNo = 1; //为学号赋值1
        stu1.name = "小明";
        stu1.age = 18;
        stu1.sex = '男';
        stu1.phone = 12345678911L;
        stu1.address = "重庆市渝中区";


        //获取对象中的属性值
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
