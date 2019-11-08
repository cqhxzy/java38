package room2;

public class Test {

    /**
     * 无参数，无返回值类型的方法
     * 调用calc方法，不需要传递任何参数
     * 调用calc方法后，方法调用者得不到任何东西
     *
     * void：空的意思
     */
    public void calc(){
        int num1 = (int)(Math.random() * 10);
        int num2 = (int)(Math.random() * 10);

        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }

    /**
     * 这是一个无参数，有返回值类型的方法
     * 调用者会得到一个10以内的随机数
     * @return
     */
    public int random(){
        int ran = (int)(Math.random() * 10);

        //return 返回的意思
        return ran;
    }

    /**
     * 有参数，无返回值类型
     * @param num1  第一个数
     * @param num2  第二个数
     */
    public void calc(int num1,int num2){
        int sum = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + sum);
    }

    /**
     * 有参数，有返回值的方法
     * @param fruit 水果名称
     * @return  水果汁
     */
    public String juce(String fruit){
        return fruit + "汁";
    }
    public static void main(String[] args) {
        //calc方法是Test类的实例方法，必须通过Test类的实例访问
        Test test = new Test(); //创建Test类的实例（实例化Test类的对象）
        //test.calc();

//        int ran = test.random(); //接收方法返回的值
//        System.out.println(ran);

//        test.calc(3,6); //没有返回值类型
        String juce = test.juce("橙子");
        System.out.println(juce);
    }
}
