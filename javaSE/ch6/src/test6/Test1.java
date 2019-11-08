package test6;

public class Test1 {
    public static void main(String[] args) {
        //类  对象  = new 类名();
        int i = 0; //基本数据类型
        Integer num = new Integer("0"); //引用数据类型

        System.out.println(i == num);

        int i1 = num.intValue(); //获取其int类型的值

        Double d = new Double(3.14);
        int i2 = d.intValue();//将double类型的变量转换为int类型
        Byte b = new Byte("2");

        /*
        * 8个中基本数据类型中，有6个值类型
        * 这六个值类型：Byte,Short,Integer,Long,Float,Double
        * 它们都继承了Number抽象类
        * Number具有的方法：
        *   byteValue()
        *   shortValue()
        *   intValue()
        *   longValue()
        *   floatValue()
        *   doubleValue()
        * */
        Integer integer = Integer.valueOf(8);//将整数转换为Integer对象
        Integer integer1 = Integer.valueOf("555"); //将字符串转换为Integer

        int i3 = Integer.parseInt("55566");//将字符串转换为int

        int max = Integer.max(10, 6);//返回10
        int min = Integer.min(10, 6); //返回6

        //将基本数据类型的5保存到引用数据类型中。装箱
        Integer integer2 = 5;

        //将引用数据类型的值保存到了基本数据类型的变量。拆箱
        int i4 = integer2;
    }
}
