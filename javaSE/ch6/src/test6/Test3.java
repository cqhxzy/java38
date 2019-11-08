package test6;

import java.util.Properties;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        /*
        返回系统中所有的键的名称
         */
        Set<String> strings = properties.stringPropertyNames();
        for (String key : strings) {
            String value = System.getProperty(key);
            System.out.println(key + "\t" + value);
        }
    }
}
