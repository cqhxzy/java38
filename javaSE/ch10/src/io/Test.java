package io;

import sun.security.action.GetPropertyAction;

import java.security.AccessController;
import java.util.Optional;
import java.util.Properties;

public class Test {
    /**
     * 获取当前操作系统对应的换行符
     * window换行： \r\n
     * Linux换行：  \n
     * @param args
     */
    public static void main(String[] args) {
        /*char[] chars = AccessController.doPrivileged(
                new GetPropertyAction("line.separator")).toCharArray();
        for (char aChar : chars) {
            int i = aChar;
            System.out.println(i);
        }*/

        Properties properties = System.getProperties();
        /*for (Object key : properties.keySet()) {
            System.out.println(key);
        }*/
        Optional<String> first = properties.keySet().stream()
                .map(t -> {   //将object类型的键转换为String类型
                    String key = (String) t;
                    return key;
                })
                //过滤，找到键已file.encoding结尾的键
                .filter(t -> t.endsWith("file.encoding"))
                //从properties集合中，根据键取值
                .map(t -> (String) properties.get(t))
                //只取第一个
                .findFirst();
        String charSet = first.orElse("null");
        System.out.println(charSet);

    }
}
