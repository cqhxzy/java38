import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Test2 {
    /**
     * 通过dom4j创建一个xml文档
     * @param args
     */
    public static void main(String[] args) {
        //通过dom4j创建一个空白的文档
        Document document = DocumentHelper.createDocument();
        //在document中创建root根节点
        Element root = document.addElement("root");

        //students节点
        Element students = root.addElement("students");
        Element student = students.addElement("student");
        student.addAttribute("role", "admin");//为student节点增加属性
        student.addElement("name").setText("张三");
        student.addElement("age").setText("18");
        student.addElement("sex").setText("女");
        student.addElement("phone").setText("1111111");
        student.addElement("email").setText("1111111@163.com");

        try {

            //指定xml格式
            //OutputFormat format = OutputFormat.createCompactFormat();//紧凑格式，没有缩进
            OutputFormat format = OutputFormat.createPrettyPrint();//有缩进
            Writer writer = new FileWriter("students.xml");
            XMLWriter xmlWriter = new XMLWriter(writer, format);
            //保存document到文件
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
