package entity;

public class Demo {
    private String str;
    public Integer num;
    double pi;
    protected char c;

    @Override
    public String toString() {
        return "Demo{" +
                "str='" + str + '\'' +
                ", num=" + num +
                ", pi=" + pi +
                ", c=" + c +
                '}';
    }
}
