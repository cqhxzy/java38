package test4;

public class Test5 {
    public static void main(String[] args) {
        String str = "zhangsanQQQQQQQQQQQQlisiUUUUUUUUUUwangwu";
        String s = str.replaceAll("(.)\\1+", "#");
        System.out.println(s);

        //  $1 指获取捕获组中编号为1保存的文本
        String s2 = str.replaceAll("(.)\\1+", "$1");
        System.out.println(s2);

        //替换手机号
        String s3 = "18996118521".replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1恭喜发财$3");
        System.out.println(s3);
    }
}
