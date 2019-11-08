package game.poker;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 花色
 *
 * @author Administrator
 */
public enum Shape {
    /*
     * 黑桃 > 红桃  > 梅花 > 方片
     * */
    BLACK_HEART("♠"),
    RED_HEART("♥"),
    FLOWER("♣"),
    SQUARE("♦");

    private String value;

    Shape(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Shape findShapeByValue(String shape) {
        Shape[] values = Shape.values();
        /*for (int i = 0; i < values.length; i++) {
            if (values[i].getValue().equals(value)) {
                return values[i];
            }
        }*/

        //使用JDK8 Stream API 获取
        Optional<Shape> first = Stream.of(values)
                .filter(t -> t.getValue().equals(shape))
                .findFirst();
        //如果first啥都没有就返回null
        return first.orElse(null);
    }
}
