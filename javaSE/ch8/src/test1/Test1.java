package test1;

public class Test1 {
    public static void main(String[] args) {
        divide(10, 0);
    }

    private static void divide(int num1, int num2) {
        if (num2 == 0) {
            //一旦除数为0了，应该抛出一个异常的实例
            /*
            * 运行时异常继承自RuntimeException
            * 运行时异常不需要做特殊处理
            * 异常本身是一个类，抛出的异常本质上为异常的对象
            * throw，向外抛出一个异常的实例
            * */
            /*RuntimeException re = new RuntimeException("除数不能为0！");
            throw re;*/
            //throw new RuntimeException("除数不能为0！");
            throw new ByZeroException("输出不能为0！");
        }
        int result = num1 / num2; //除数不能为0
        System.out.println(result);
    }

    /**
     * 自定义的异常
     */
    private static class ByZeroException extends RuntimeException {
        public ByZeroException() {
        }

        public ByZeroException(String message) {
            super(message);
        }
    }

}
