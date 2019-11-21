import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class Test4 {
    /**
     * 测试java内省机制
     * @param args
     */
    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);
            //用于描述属性
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String name = propertyDescriptor.getName();
                if (!name.equals("class")) {
                    System.out.println(name); //获取属性名；实际上是根据getXXX的方法来反推属性名
                    //setter和getter
                    Method readMethod = propertyDescriptor.getReadMethod();//得到当前属性的getter方法
                    Method writeMethod = propertyDescriptor.getWriteMethod();//得到当前属性的setter方法

                    System.out.println(readMethod.getName());
                    System.out.println(writeMethod.getName());
                    System.out.println("---------------------");
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
