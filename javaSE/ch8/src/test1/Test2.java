package test1;

public class Test2 {
    public static void main(String[] args) {
        /*
        * 编译时异常强制要求用户对异常进行处理
        *
        * 方法声明中的throws代表着异常声明
        * 异常声明告诉方法的调用者，调用这个方法有可能出现什么异常
        * 方法的调用者根据异常的种类进行不同的处理
        * */
        try {//可能出现异常的代码块
            divide(1, 0);
        } catch (ByZeroException e) {  //被捕获到的异常
            //记录日志
            System.out.println("除数不能为0");
            e.printStackTrace();
        } catch (MyException e) {
            System.out.println("被除数不能为负数");
            e.printStackTrace();
        } catch (Exception e){ //把最大的异常类型对应的catch放到最后
            e.printStackTrace();
        } finally {
            System.out.println("程序执行结束");
        }
    }

    /**
     * 两个数相除，除数必须不能为0
     *
     * 在调用方法时，往往需要根据不同的异常做不同的处理
     * 因此我们通常需要自定义异常
     * @param num1
     * @param num2
     */
    private static void divide(int num1, int num2) throws ByZeroException,MyException{
        if (num2 == 0) {
            //抛出异常的实例
            throw new ByZeroException("除数不能为0！");
        }
        if (num1 < 0) {
            throw new MyException("被除数不能为负数");
        }
        System.out.println(num1 / num2);
    }

    /**
     * 自定义的编译时异常
     */
    private static class ByZeroException extends Exception {
        public ByZeroException(String message) {
            super(message);
        }
    }

    /**
     * 自定义的一个被除数不能为负数的异常
     */
    private static class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }


}
