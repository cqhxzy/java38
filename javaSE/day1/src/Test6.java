import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int m = 0;
        while(m < 10000){
            m+=400;
            System.out.println("完成第" + m + "米的比赛");
            System.out.println("还能坚持吗？ y/n");
            String next = input.next();//
            if (next.equals("n")){ //不能坚持比赛了
                System.out.println("坚持不了了，比赛提前结束");
                break;//break会结束当前所在循环的执行
            }
        }
    }
}
