package test;

import entity.Food;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class TestConstructor {
    public static void main(String[] args) throws Exception {

        //test1();
        test2();
    }

    /**
     * 通过指定的参数列表实例化对象
     */
    private static void test2() throws Exception {
        Class<Food> foodClass = Food.class;
        //Food food = foodClass.newInstance(); //通过Class中的newInstance()，调用无参构造实例化对象

        //获取无参构造
        Constructor<Food> constructor = foodClass.getConstructor();
        Food food1 = constructor.newInstance();//通过无参构造实例化对象  Food food = new Food()
        System.out.println(food1);

        //根据参数列表的类型，获取指定的有参构造
        Constructor<Food> constructor1 = foodClass.getConstructor(String.class, double.class);
        Food food2 = constructor1.newInstance("牛肉干", 15);//Food food = new Food("牛肉干"，10);
        System.out.println(food2);

    }

    /**
     * 获取构造函数
     */
    private static void test1() {
        Class<Food> foodClass = Food.class;
        /*
        * 构造函数为初始化对象时执行的方法
        * */
        //获取所有的公共的构造方法
        Constructor<?>[] constructors = foodClass.getConstructors();

        //获取所有的构造方法
        Constructor<?>[] declaredConstructors = foodClass.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            //获取访问修饰符
            String modifier = Modifier.toString(constructor.getModifiers());
            //获取构造函数的方法名
            String name = constructor.getName();
            //获取构造函数的参数个数
            int parameterCount = constructor.getParameterCount();
            System.out.println("访问修饰符：" + modifier);
            System.out.println("方法名：" + name);
            System.out.println("参数个数：" + parameterCount);
            if (parameterCount > 0) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
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
