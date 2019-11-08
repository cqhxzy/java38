package demo2;

/**
 * 鸭子类，继承Pet
 */
public class Duck extends Pet {
    @Override
    public void run() {
        System.out.println("鸭子一摇一摆的跑");
    }

    @Override
    public void shut() {
        System.out.println("鸭子嘎嘎叫");
    }
}
