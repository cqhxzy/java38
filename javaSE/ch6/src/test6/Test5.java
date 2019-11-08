package test6;

import java.math.BigInteger;

public class Test5 {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("123456789123456789123456789");
        BigInteger add = bigInteger.add(new BigInteger("1"));//求和
        System.out.println("求和：" + add.toString());

        BigInteger subtract = bigInteger.subtract(new BigInteger("1"));
        System.out.println("求差：" + subtract);

        //积
        BigInteger multiply = bigInteger.multiply(new BigInteger("2"));
        System.out.println("积：" + multiply);

        //商
        BigInteger divide = bigInteger.divide(new BigInteger("2"));
        System.out.println("商：" + divide);

        //余数
        BigInteger mod = bigInteger.mod(new BigInteger("10"));
        System.out.println("余数：" + mod);
    }
}
