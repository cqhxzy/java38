import java.util.Scanner;

public class Demo2 {
    /**
     * 接收用户输入人数，分别录入每个人的成绩
     * 统计最高分和平均分
     * 使用数组实现
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学生的人数");
        int count = input.nextInt();

        double[] scores = new double[count];
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个人的成绩");
            double score = input.nextDouble();
            scores[i] = score; //将成绩赋值到数组下标为i的空间中
        }

        System.out.println("接收用户输入成绩完成，成绩如下：");
        //遍历数组
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + "   ");
        }
        System.out.println();

        //统计最高分和平均分
        double max = scores[0]; //假设数组下标为0的值是最大的
        double sum = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
            sum += scores[i]; //累加求和
        }
        double avg = sum / scores.length;//计算平均分
        System.out.println("这" + count + "个人中，最高分为：" + max + ",平均分为：" + avg);
    }
}
