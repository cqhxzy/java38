package testSet;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

public class TestTreeSet2 {
    /**
     * 通过定制排序为集合指定顺序
     * @param args
     */
    public static void main(String[] args) {
        //TreeSet<Student> tree = new TreeSet<>(new MyComparator().reversed());//倒叙排序
        /*TreeSet<Student> tree = new TreeSet<>(new Comparator<Student>() {  //匿名实现类
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        }.reversed());*/

        //复杂的排序，根据条件及多个属性排序
        TreeSet<Student> tree = new TreeSet<>((a, b) -> {
            int compare = Integer.compare(a.getAge(), b.getAge());
            if (compare == 0) { //如果年龄相同，则比较身高
                return Double.compare(a.getHeight(), b.getHeight());
            }else{
                return compare;
            }
        });
        //通过Lambda表达式集合方法引用实现，简单排序，根据某个属性排序
        //TreeSet<Student> tree = new TreeSet<>(Comparator.comparingInt(Student::getAge).reversed());
        tree.add(new Student("a", 10,1));
        tree.add(new Student("b", 7,5));
        tree.add(new Student("c", 2,3));
        tree.add(new Student("d", 7,6));
        tree.add(new Student("e", 7,4));

        System.out.println(tree.size());

        tree.stream().forEach(System.out::println);
    }

    /**
     * 普通的静态内部类
     */
    private static class Student{
        private String name;
        private int age;
        private double height;

        public Student(String name, int age,double height) {
            this.name = name;
            this.age = age;
            this.height = height;
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

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age &&
                    Double.compare(student.height, height) == 0 &&
                    Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, height);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", height=" + height +
                    '}';
        }
    }

    /**
     * 自定义的定制排序
     */
    private static class MyComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge() - o2.getAge();
        }
    }
}
