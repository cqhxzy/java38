import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        //通过Dom4j解析xml
        SAXReader reader = new SAXReader();

        InputStream resourceAsStream = Test1.class.getResourceAsStream("test.xml");

        try {
            //document即为整个xml文档对象
            Document document = reader.read(resourceAsStream);

            //bar(document);
            //getWithXpath(document);
            getSingleNodeWithXpath(document);


        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    private static void bar(Document document) {
        //获取xml文档的根节点
        Element rootElement = document.getRootElement();
        //String name = rootElement.getName();
        //System.out.println(name);
        //String name1 = rootElement.getQName().getName();

        //获取根节点中的子节点
        /*Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()) {
            Element next = elementIterator.next();//得到根节点中的子节点
            //System.out.println(next.getName());  students,books
            List<Element> elements = next.elements();
            for (Element element : elements) {
                System.out.println(element.getName());
            }
            System.out.println();
        }*/

        //从根节点中获取所有的students子节点
        List<Element> students = rootElement.elements("students");
        for (Element student : students) {
            //从students节点中获取所有的student节点
            List<Element> student1 = student.elements("student");
            for (Element element : student1) {
                //System.out.println(element.getName());   student
                Attribute role = element.attribute("role");
                String value = role.getValue();
                String name = role.getName();
                System.out.println(name + ":" + value);
            }
        }
    }

    private static void getWithXpath(Document document) {
        List<Node> nodes = document.selectNodes("//root/students/student");
        for (Node node : nodes) {
            String name = node.getName();//节点名
            Element element = (Element) node; //将node强制转换为element
            List<Element> elements = element.elements();//读取student节点中的所有子节点
            for (Element element1 : elements) {
                //System.out.println(element1.getName());
                String text = element1.getText(); //所有文本的类型均为string
                String name1 = element1.getName();
                System.out.println(name1 + ":" + text);
            }
            System.out.println("-------");
        }
    }

    private static void getSingleNodeWithXpath(Document document){
        Node node = document.selectSingleNode("//root/books/book");
        Element element = (Element) node;//只有Element才能得到子节点
        Element name = element.element("name"); //在book节点中获取name节点
        Element price = element.element("price");//在book节点中获取price节点

        String text = name.getText();
        String text1 = price.getText();
        System.out.println(text + "  " + text1);
    }
}
