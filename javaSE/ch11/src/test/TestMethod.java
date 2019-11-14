package test;

import entity.Food;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestMethod {
    public static void main(String[] args) throws Exception {
        //test1();
        test2();
    }

    /**
     * 通过反射调用方法并得到结果
     */
    private static void test2() throws Exception{
        Class<Food> foodClass = Food.class;

        //创建对象
        Food food = foodClass.newInstance();

        //foodClass.getMethod()
        //根据方法名和参数列表获取指定的方法
        Method setName = foodClass.getDeclaredMethod("setName", String.class);

        //要通过反射执行方法，必须指定该方法的对象
        //对象.方法()
        setName.invoke(food, "豆腐干");

        Method setPrice = foodClass.getDeclaredMethod("setPrice", double.class);
        setPrice.invoke(food, 5);

        Method toString = foodClass.getMethod("toString");
        Object invoke = toString.invoke(food);//执行food对象的toString方法
        System.out.println(invoke);
    }

    /**
     * 读取类中的方法
     */
    private static void test1() {
        //通过反射，执行类中的方法
        //反射中，任何一个方法都可以通过Method对象表示
        Class<Food> foodClass = Food.class;

        //获取Food类中所有的公共方法以及父类中继承的方法
        Method[] methods = foodClass.getMethods();
        //System.out.println(methods.length);
        for (Method method : methods) {
            //获取方法名
            String name = method.getName();
            //System.out.println(name);
        }

        //获取Food类中所有的方法
        Method[] declaredMethods = foodClass.getDeclaredMethods();
        //System.out.println(declaredMethods.length);
        for (Method method : declaredMethods) {
            //获取方法名
            String name = method.getName();

            //获取访问修饰符
            String modifier = Modifier.toString(method.getModifiers());

            //返回值类型
            String returnType = method.getReturnType().getName();

            //获取方法的参数个数
            int parameterCount = method.getParameterCount();
            System.out.println(name);
            System.out.println("访问修饰符：" + modifier);
            System.out.println("返回值类型：" + returnType);
            System.out.println("参数个数：" + parameterCount);
            if (parameterCount > 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();

                StringBuilder builder = new StringBuilder();
                for (Class<?> parameterType : parameterTypes) {
                    //拼接参数类型
                    builder.append(parameterType.getName() + "\t");
                }
                System.out.println(builder);
            }
            System.out.println();
        }
    }
}
