package test1;

public class Test1 {
    public static void main(String[] args) {
        Demo demo1 = new Demo("abc");
        Demo demo2 = new Demo("123");

        /**
         * 比较两个对象的内存地址是否相同
         */
        //boolean equals = demo1.equals(demo2);
        //System.out.println(equals);

        System.out.println(demo1.hashCode());
        System.out.println(demo1);

        System.out.println(demo2.hashCode());

        int i = 1163157884; //4554617c
        String s = Integer.toHexString(i);
        System.out.println(s.equals("4554617c"));
    }
}
