public class Test2 {
    public static void main(String[] args) {
        //模拟1-100个人报数
        int i = 1; //假设从1开始报数
//        System.out.println(i++);  //1
//        System.out.println(i);   //2
//        System.out.println(++i); //3
        while (i <= 100){
            System.out.println("第" + i + "个人开始报数");
            i++;// i = i + 1;  ++i和i++的区别
        }
        System.out.println("1-100人报数完毕！");
    }
}
