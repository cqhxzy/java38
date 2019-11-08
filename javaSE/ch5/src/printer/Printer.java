package printer;

public interface Printer {
    /**
     * 打印信息的能力
     * @param str
     */
    void print(String str);

    /**
     * 扫描数据的能力
     */
    void scan();
}
