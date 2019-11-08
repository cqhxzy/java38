package homework;

public class Test14 {
    public static void main(String[] args) {
        double paper = 0.08 / 100; //一张纸的厚度为多少米
        double m = paper;
        int count = 0;
        while (m < 8848.13) {
            m *= 2;
            count++;
        }
        System.out.println(count);
    }
}
