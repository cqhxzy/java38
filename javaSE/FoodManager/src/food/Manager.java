package food;

import java.util.Arrays;

/**
 * 食品数组的管理类
 */
public class Manager {
    //数组默认长度为100
    private final int INIT_CAPBILITY = 100;
    private Food[] foods = new Food[INIT_CAPBILITY];

    //用于统计数组中实际存放食品的个数
    private int size = 0;

    /**
     * 新增食品的方法
     * 后端程序不需要关心food对象是什么样的
     * 谁调用addFood方法，谁就负责组建Food对象
     * @param food
     * @return 布尔值，成功为true，失败为false
     */
    public boolean addFood(Food food){

        Food byName = this.findByName(food.getName());
        if (byName == null) {
            if (size + 1 > INIT_CAPBILITY) { //超出数组能够容纳的最大长度
                return false; //新增失败
            }
            foods[size++] = food;
        } else {
            byName.setCount(byName.getCount() + food.getCount());
        }
        return true;
    }

    /**
     * 根据食品名称查询食品对象
     * @param name
     * @return
     */
    public Food findByName(String name){
        for (int i = 0; i < size; i++) {
            Food food = foods[i];
            if (food != null && food.getName().equals(name)) {
                return food;
            }
        }
        //如果遍历完成后都没发现食品对象，说明数组中不存在name对应食品信息
        return null;
    }

    /**
     * 根据食品名称修改食品价格
     * @param name
     * @param price
     * @return
     */
    public boolean updatePrice(String name,double price){
        //根据食品名称查询食品
        Food byName = findByName(name); //在数组中存在的同名的食品对象
        //修改查询的食品
        if (byName == null) return false;

        byName.setPrice(price);
        return true;
    }

    /**
     * 统计所有食品的总价格
     * @return
     */
    public double totalMoney(){
        double totalMoney = 0;
        for (int i = 0; i < size; i++) {
            Food food = foods[i];
            if (food != null){
                // 单价 * 数量
                double money = food.getPrice() * food.getCount();
                totalMoney += money;
            }
        }
        return totalMoney;
    }

    /**
     * 统计最贵的食品信息
     * @return
     */
    public Food[] getMaxPriceFoods(){
        Food[] max = null;
        //如果数组中什么都没有，则没有最贵的食品信息
        if (size == 0) return null;
        //如果数组中只有一个食品信息，则直接返回长度为1的数组
        if (size == 1) {
            max = new Food[size];
            max[size - 1] = foods[size - 1];
        } else {
            //1.最贵的食品价格是多少
            double max_price = foods[0].getPrice(); //假设第一个食品是最贵的
            for (int i = 1;i < size;i++){
                if (foods[i] != null && foods[i].getPrice() > max_price){
                    max_price = foods[i].getPrice();
                }
            }
            //2.统计最贵的食品的数量
            int count = 0;
            for (int i = 0; i < size; i++) {
                if (foods[i] != null && foods[i].getPrice() == max_price) count++;
            }

            //3.根据数量创建对应的食品数组
            max = new Food[count];
            //4.将最贵的食品信息添加到数组中
            int index = 0;
            for (int i = 0; i < size; i++) {
                if (foods[i] != null && foods[i].getPrice() == max_price){
                    max[index++] = foods[i];
                }
            }
        }
        //5.返回数组
        return max;
    }

    /**
     * 根据食品价格升序排序数组
     * @return
     */
    public Food[] sortByPrice(){
        if (size == 0) {
            return null;
        }

        //将foods中的所有食品复制到新数组中
        Food[] foods = Arrays.copyOf(this.foods,this.size);

        //System.out.println(Arrays.toString(foods));
        //System.out.println(foods == this.foods);

        //对新数组进行排序
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                double left = foods[j].getPrice();
                double right = foods[j + 1].getPrice();
                if (left > right) {
                    Food target = foods[j];
                    foods[j] = foods[j + 1];
                    foods[j + 1] = target;
                }
            }
        }
        return foods;
    }
}
