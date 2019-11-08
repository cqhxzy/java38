package test7;

/**
 * jdk8中提出了函数式编程风格的接口
 * 满足函数式编程风格的接口中只能有一个抽象方法
 * 或者N个默认方法组成，Object中的方法除外
 *
 * 默认方法具有方法体
 */
@FunctionalInterface
public interface MyFunctionalInterface {

    void test();

    boolean equals(Object object);

    /**
     * 默认方法，具有方法体
     */
    default void test3(){
        System.out.println("执行默认方法");
    }
}
