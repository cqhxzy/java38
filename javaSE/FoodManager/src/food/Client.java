package food;

import java.util.Scanner;

/**
 * 场景类，模拟食品管理程序的整个过程
 */
public class Client {
    private Manager manager = new Manager();//食品管理类，唯一的
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    /**
     * 运行食品管理系统的方法
     */
    public void run(){
        System.out.println("##############食品管理系统#################");
        boolean running = true;
        while (running){
            System.out.println("1.新增食品");
            System.out.println("2.根据名称查询食品");
            System.out.println("3.根据名称修改食品价格");
            System.out.println("4.统计所有食品总价格");
            System.out.println("5.统计最贵的食品信息");
            System.out.println("6.按照食品价格升序排序");
            System.out.println("7.根据名称删除食品信息");
            System.out.println("8.退出程序");

            System.out.println("请选择：");
            int choose = input.nextInt();
            switch (choose) {
                case 1:
                    addFood();
                    break;
                case 2:
                    findByName();
                    break;
                case 3:
                    updatePrice();
                    break;
                case 4:
                    totalMoney();
                    break;
                case 5:
                    getMaxPriceFoods();
                    break;
                case 6:
                    sortByPrice();
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("谢谢使用，再见！");
                    running = false;
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入！");
                    break;
            }
        }
    }

    /**
     * 前端使用的添加食品的方法
     */
    public void addFood(){
        System.out.println("请输入食品名称");
        String name = input.next();
        System.out.println("请输入食品单价");
        double price = input.nextDouble();
        System.out.println("请输入食品数量");
        int count = input.nextInt();

        Food add = new Food(name, price, count);
        boolean addFood = manager.addFood(add);
        System.out.println(addFood ? "添加成功！":"添加失败！");
    }

    /**
     * 前端的根据食品名称查询食品信息
     */
    public void findByName(){
        System.out.println("请输入食品名称");
        String name = input.next();
        Food byName = manager.findByName(name);
        if (byName == null) {
            System.out.println("查无此食品信息！");
        } else {
            System.out.println("名称\t\t单价\t\t数量");
            System.out.println(byName.getName() + "\t\t" + byName.getPrice() + "\t\t" + byName.getCount());
        }
    }

    public void updatePrice(){
        System.out.println("请输入食品名称");
        String name = input.next();
        Food food = manager.findByName(name);

        if (food == null) {
            System.out.println("查无此食品信息！");
        }
        else{
            System.out.println("请输入新品价格");
            double price = input.nextDouble();
            boolean updatePrice = manager.updatePrice(name, price);
            System.out.println(updatePrice ? "修改成功！" : "修改失败！");
        }

    }

    public void totalMoney(){
        double totalMoney = manager.totalMoney();
        System.out.println("所有食品的总价格：" + totalMoney);
    }

    public void getMaxPriceFoods(){
        Food[] maxPriceFoods = manager.getMaxPriceFoods();
        printFoodArray(maxPriceFoods);
    }

    /**
     * 输出数组
     * @param foods
     */
    private void printFoodArray(Food[] foods) {
        if (foods == null) {
            System.out.println("暂无库存信息！");
            return;  //退出方法
        }

        System.out.println("名称\t\t单价\t\t数量");
        for (int i = 0; i < foods.length; i++) {
            Food maxPriceFood = foods[i];
            System.out.println(maxPriceFood.getName() + "\t\t" + maxPriceFood.getPrice() + "\t\t" + maxPriceFood.getCount());
        }
    }

    public void sortByPrice(){
        Food[] foods = manager.sortByPrice();
        printFoodArray(foods);
    }
}
