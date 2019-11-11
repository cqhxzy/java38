package test4;

public class Test {
    public static void main(String[] args) {
        /*try {
            //仅触发，将Single的字节码文件加载到方法区
            Class.forName(Singleton.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}
