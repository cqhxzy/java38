package food;

public class Test {
    public static void main(String[] args) {
        Food food1 = new Food("牛肉干",10,1);
        Food food2 = new Food("豆腐干",2,10);
        Food food3 = new Food("羊肉干",10,4);
        Food food4 = new Food("鱼翅",100,4);

        Manager manager = new Manager();
        manager.addFood(food1);//添加牛肉干
        manager.addFood(food2);//添加豆腐干
        manager.addFood(food3);//添加羊肉干
        manager.addFood(food4);//添加鱼翅



       /* boolean updatePrice = manager.updatePrice("牛肉干", 15);
        System.out.println(updatePrice ? "修改成功": "修改失败");

        Food findByName = manager.findByName("牛肉干");
        System.out.println(findByName);*/

        /*double totalMoney = manager.totalMoney();
        System.out.println("所有食品的总价格：" + totalMoney);*/

        //Food[] maxPriceFoods = manager.getMaxPriceFoods();


        Food[] foods = manager.sortByPrice();

        for (int i = 0; i < foods.length; i++) {
            Food maxPriceFood = foods[i];
            System.out.println(maxPriceFood);
        }
    }
}
