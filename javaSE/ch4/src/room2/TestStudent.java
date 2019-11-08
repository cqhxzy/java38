package room2;

import room1.Student; //因为Student类在room1包中，因此在本类中使用Student之前必须先导包

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student();
        //观察提示得知只能够访问Student类中被public修饰的属性
        student.name = "张三";
        student.stuNo = 1;
    }
}
