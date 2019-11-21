import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Test3 {
    /**
     * 结合students.xml
     * 创建Student类，属性和student中的节点必须完全相同
     * 通过反射，将xml文档中的数据取出，并保存到List<Student>集合中
     * @param args
     */
    public static void main(String[] args) {
        /*List<Student> student = convert("Student","students.xml");
        student.stream().forEach(System.out::println);*/

        List<Food> foods = convert("Food", "foods.xml");
        foods.stream().forEach(System.out::println);
    }

    private static <T> List<T> convert(String className,String path){
        try {
            Class<?> aClass = Class.forName(className);
            String name = aClass.getName().toLowerCase(); //获取类名
            List<T> objList = new ArrayList<>();
            //System.out.println(name);

            //检测xml中是否包含name的节点
            SAXReader saxReader = new SAXReader();
            Document read = saxReader.read(Test3.class.getResourceAsStream(path));

            List<Element> elementByName = getElementByName(read, name);
            if (elementByName.size() <= 0) {
                throw new RuntimeException("xml文件中没有" + name + "对应的节点信息");
            } else {
                for (Element element : elementByName) {
                    //name,age,sex
                    List<Element> elements = element.elements();
                    T o = (T) aClass.newInstance();
                    for (Element element1 : elements) {
                        String name1 = element1.getName();//和Student类中的属性名对应
                        String text = element1.getText();//值
                        BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
                        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
                        Optional<PropertyDescriptor> any = Stream.of(propertyDescriptors)
                                .filter(t -> t.getName().equals(name1))
                                .findAny();
                        if (!any.isPresent()) {
                            throw new RuntimeException(aClass + " 中不能存在属性名为" + name1 + "的属性");
                        } else {
                            PropertyDescriptor propertyDescriptor = any.get();
                            Method writeMethod = propertyDescriptor.getWriteMethod();//获取setter方法
                            //将字符串的值转换为属性对应的类型
                            Class<?> parameterType = writeMethod.getParameterTypes()[0];
                            Object o1 = conver2Type(parameterType, text);
                            writeMethod.invoke(o,o1);//执行setter方法，为对象赋值
                        }
                    }
                    objList.add(o);//将赋值完成的对象保存到集合

                }
                return objList;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据类名在xml中查找同名的节点
     * @param document
     * @param name
     * @return
     */
    private static List<Element> getElementByName(Document document, String name) {
        Element rootElement = document.getRootElement();
        List<Element> list = new ArrayList<>();
        if (rootElement.getName().equalsIgnoreCase(name)) {
            list.add(rootElement);
            return list;
        } else {
            //获取根节点下所有的子节点
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                test(element, name, list);
            }
        }
        return list;
    }

    /**
     * 通过递归查找xml中和类名相同的节点
     * @param e
     * @param name
     * @param list
     */
    private static void test(Element e, String name,List<Element> list) {
        if (e.getName().equalsIgnoreCase(name)) {
            list.add(e);
        } else {
            //获取根节点下所有的子节点
            List<Element> elements = e.elements();
            for (Element element : elements) {
                test(element, name,list);
            }
        }
    }

    private static Object conver2Type(Class claz, String value) {
        if (claz == int.class) {
            return Integer.parseInt(value);
        } else if (claz == String.class) {
            return value;
        } else if (claz == char.class) {
            return value.charAt(0);
        } else if (claz == double.class) {
            return Double.parseDouble(value);
        }
        return null;
    }

}
