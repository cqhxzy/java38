package test1;

public class Demo {
    private String str;

    public Demo(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) { //如果当前对象的内存地址和obj相同，直接返回true
            return true;
        }

        if (obj == null) {
            return false;
        }

        //判断obj是否为Demo的类型
        if (!(obj instanceof Demo)) {
            return false;
        }

        Demo demo = (Demo)obj; //将Object类型的obj对象强制转换为Demo类型;

        return this.str.equals(demo.str);
    }

    /**
     * 将Demo对象转换为String字符串的方法
     * @return
     */
    @Override
    public String toString() {
        return "Demo{" +
                "str='" + str + '\'' +
                '}';
    }
}