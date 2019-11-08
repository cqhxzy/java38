package testList;

import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = {0,2,7,4,5};
        //Stream.of(arr).forEach(x-> System.out.println(x));
        Stream.of(arr).forEach(System.out::println);
    }
}
