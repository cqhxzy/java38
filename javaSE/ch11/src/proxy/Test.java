package proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {

        /**
         * 通过Proxy代理动态生成一个Class类,其为动态代理的类
         */
        Class<?> proxyClass = Proxy.getProxyClass(ClassLoader.getSystemClassLoader(), Work.class);
        /*Method[] declaredMethods = proxyClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }*/

        //动态产生的一个经纪人
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();//得到system classLoader
        Class<?>[] interfaces = SuperStar.class.getInterfaces();//得到明星相同的接口
        //InvocationHandler接口中只有一个方法，invoke
        //因此通过lambda表达式匿名实现
        //invoke(代理对象，被执行的方法，方法的参数)
        Work proxy = (Work) Proxy.newProxyInstance(classLoader, interfaces, (p, m, arg) -> {
            SuperStar pyy = new SuperStar("彭于晏");
            System.out.println("经纪人已经谈好了价格，明星开始做业务");
            m.invoke(pyy, arg);
            System.out.println("明星业务完成");
            return null;
        });

        //客户只能够通过经纪人访问明星
        proxy.ad();
        proxy.tv();
    }
}
