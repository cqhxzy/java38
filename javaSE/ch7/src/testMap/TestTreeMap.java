package testMap;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    private static void test2(){
        //使用自定义的类型作为键时，必须实现Comparable接口
        TreeMap<Demo, String> tree = new TreeMap<>();
        tree.put(new Demo(5), "a");
    }

    /**
     * 使用定制排序为键排序
     */
    private static void test3(){
        TreeMap<Demo2, String> tree = new TreeMap<>(Comparator.comparingInt(Demo2::getI));
        tree.put(new Demo2(5), "a");
    }

    /**
     * 通过String作为键进行自然排序
     */
    private static void test1() {
        TreeMap<String, Integer> tree = new TreeMap<>();
        tree.put("f", 1);
        tree.put("a", 2);
        tree.put("y", 3);
        tree.put("c", 4);
        tree.put("t", 5);

        Set<Map.Entry<String, Integer>> entries = tree.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "\t" + value);
        }
    }

    private static class Demo implements Comparable<Demo>{
        private int i;

        public Demo(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        @Override
        public int compareTo(Demo o) {
            return this.i - o.i;
        }
    }

    private static class Demo2{
        private int i;

        public Demo2(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }
}
