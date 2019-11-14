package test;

import entity.Demo;
import entity.Food;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestField {
    public static void main(String[] args) throws Exception {
        //getFields();
        setAndGet();
    }

    /**
     * 通过反射为类中的属性赋值及取值的操作
     */
    private static void setAndGet() throws Exception {
        //通过反射实例化对象
        Class<Demo> aClass = Demo.class;
        Demo demo = aClass.newInstance();//通过反射，调用无参构造实例化对象

        Field num = aClass.getField("num");//num属性的Field
        //为num属性赋值
        //set(object,value);  要为哪个对象的num属性赋value值
        num.set(demo, 10);

        //通过反射获取num属性的值
        Object num_value = num.get(demo);//从demo对象中获取num属性的值
        //System.out.println("num:" + num_value);

        Field str = aClass.getDeclaredField("str");//获取私有的str属性
        //私有的属性不能够对其直接赋值
        //设置属性的可见性
        str.setAccessible(true); //设置私有的str属性可见

        str.set(demo, "hello"); //赋值
        Object str_value = str.get(demo);
        //System.out.println(str_value);

        Field pi = aClass.getDeclaredField("pi");
        pi.setAccessible(true);

        pi.set(demo, 3.14);
        Object pi_value = pi.get(demo);
        //System.out.println(pi_value);

        System.out.println(demo);
    }


    /**
     * 获取类中的属性信息
     */
    private static void getFields() {
        //得到Class
        Class<Demo> aClass = Demo.class;

        //获取类中pubilc修饰的属性
        Field[] fields = aClass.getFields();
        //System.out.println(fields.length);

        //获取类中所有的属性，包括public，private，protected，默认的
        Field[] declaredFields = aClass.getDeclaredFields();
        //System.out.println(declaredFields.length);
        for (Field field : declaredFields) {
            int modifiers = field.getModifiers();//获取访问修饰符
            String modifier = Modifier.toString(modifiers);//获取int类型的访问修饰符对应的字符串
            System.out.println("访问修饰符：" + modifier);

            //获取field对应的属性的类型
            String type = field.getType().getName();
            System.out.println("类型：" + type);

            //获取Field对应属性的名称
            String name = field.getName();
            System.out.println("属性名：" + name);
            System.out.println();
        }
    }
}
