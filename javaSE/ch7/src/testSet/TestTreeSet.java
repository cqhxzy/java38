package testSet;

import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<Student> tree = new TreeSet<>();//默认的已自然排序，排序集合中的元素
        /*
        * 每次在向TreeSet集合中插入数据时，集合都会尝试对对象进行排序
        * 每个待排序的对象，TreeSet都会将它装换为Comparable的对象。
        * 因此需要将待排序的对象的类实现Comparable接口并重写其中的方法
        * Comparable obj = (Comparable)student;
        * */
        tree.add(new Student("a", 10));
        tree.add(new Student("b", 7));
        tree.add(new Student("c", 2));
        tree.add(new Student("d", 8));

        //返回集合中年龄大于等于7的最小的学生对象
        Student e = tree.ceiling(new Student("e", 9));
        Student first = tree.first();//返回集合中年龄最小的学生
        Student last = tree.last(); //返回集合中年龄最大的学生
        Student e1 = tree.higher(new Student("e", 7));
        Student e2 = tree.lower(new Student("e", 10));
        System.out.println(e2);
        /*for (Student student : tree) {
            System.out.println(student);
        }*/
    }

    /**
     * 根据年龄做升序排序
     *
     * 自然排序需要实现Comparable接口并重写compareTo方法
     */
    private static class Student implements Comparable<Student>{
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

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int compareTo(Student stu) {
            /*
                将当前的student对象和目标student对象做比较
                如果当前学生对象this比目标对象stu的年龄大，则返回正数
                如果两个学生对象年龄相同，则返回0
                否则返回负数
             */
            return this.age - stu.age;
        }
    }
}
