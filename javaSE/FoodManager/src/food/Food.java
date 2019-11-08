package food;

/**
 * 食品类
 */
public class Food {
    /*
    * 属性的封装
    * 隐藏类的内部实现，对外提供公共的方法访问类的属性
    *
    * private: 私有的意思，被private修饰的属性和方法仅在本类中可见
    *
    * 每个属性都具备取值和赋值的操作
    * 封装在整个java行业中具有相同的规范
    * 赋值通过setXxx为方法命名
    * 取值通过getXxx为方法命名
    *
    * 因为很多第三方的框架就是根据这种规范来对属性进行访问
    * 其中非常著名为java内省机制
    * */
    private String name; //视频名称
    private double price; //价格
    private int count; //数量

    public Food() {
    }

    public Food(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    /**
     * 为name属性赋值的封装方法
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 获取name属性值的封装方法
     * @return
     */
    public String getName() {
        return this.name;
    }

    public void setPrice(double price) {
        if (price < 0) price = 0;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setCount(int count) {
        if (count < 0) count = 0;
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    //ctrl + o,重写Object类中的toString方法。

    @Override
    public String toString() {
        return "name：" + this.name + ",price：" + this.price + "，count：" + this.count;
    }
}
