package test7;

import java.util.function.Function;

public class Test4 {
    public static void main(String[] args) {

        Function<Integer,String> f = a -> String.valueOf(a) + Math.random() * 10;

        String apply = f.apply(10);
        System.out.println(apply);

        /**
         * Function接口中apply方法的匿名实现
         * R apply(T t)
         * R指返回值类型
         * T形参类型
         */
        Function<Student,String> f2 = (stu) ->{
            String name = stu.getName();
            int age = stu.getAge();
            StringBuilder builder = new StringBuilder();
            builder.append("姓名：" + name)
                    .append("年龄：" + age);
            return builder.toString();
        };
        Student student = new Student("admin", 18);
        String apply1 = f2.apply(student);
        System.out.println(apply1);
    }

    private static class Student{
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
