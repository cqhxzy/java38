package room2;

/*
*
* Car car = new Car(); //通过调用Car的无参构造函数实例化Car的对象
* */
public class Car {

    /**
     * 这是Car的构造函数，在new Car的时候被调用
     * 在调用时就为属性赋值了
     */
    public Car(){
        System.out.println("正在实例化Car的对象");
        brand = "大众";
        price = 488888;
        color = "神秘黑";
    }

    /**
     * 有参构造函数
     * @param brand
     */
    public Car(String brand,double price,String color){ //形参列表
        this.brand = brand;  //this代表当前类的对象
        this.price = price;
        this.color = color;

    }

    String brand;  //品牌
    double price; //价格
    String color; //颜色

    public static void main(String[] args) {
        //Car car = new Car(); //调用无参构造函数实例化Car的对象


        Car car = new Car("宝马",566666,"白色");

        System.out.println("brand:" + car.brand);
        System.out.println("price:" + car.price);
        System.out.println("color:" + car.color);
    }
}
