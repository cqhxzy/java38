package io;

import sun.security.action.GetPropertyAction;

import java.security.AccessController;
public class Test {
    /**
     * 获取当前操作系统对应的换行符
     * window换行： \r\n
     * Linux换行：  \n
     * @param args
     */
    public static void main(String[] args) {
        char[] chars = AccessController.doPrivileged(
                new GetPropertyAction("line.separator")).toCharArray();
        for (char aChar : chars) {
            int i = aChar;
            System.out.println(i);
        }
    }
}
