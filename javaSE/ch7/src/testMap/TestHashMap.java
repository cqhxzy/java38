package testMap;

import entity.Food;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestHashMap {
    public static void main(String[] args) {
        Map<String, Food> map = new HashMap<>();
        //向集合中添加元素
        map.put("a", new Food("a", 10.0, 1));
        map.put("b", new Food("b", 10.0, 1));
        map.put("c", new Food("c", 10.0, 1));

        //根据键删除元素，返回被删除的原始的值
        Food a = map.remove("a");
        //获取集合中元素的个数
        System.out.println(map.size());

        //获取map中的元素
        Food food = map.get("b");

        //判断集合中是否包含某个键
        boolean b = map.containsKey("b");

        //通过equals方法，判断集合中是否包含某个值
        boolean c = map.containsValue(new Food("c", 10.0, 1));

        //遍历map，根据键获取value值
        for (String key : map.keySet()) {
            //System.out.println(key);
            Food food1 = map.get(key);
            //System.out.println(key + "\t" + food1);
        }

        //直接获取所有的值
        Collection<Food> values = map.values();
        for (Food value : values) {
            //System.out.println(value);
        }

        Set<Map.Entry<String, Food>> entries = map.entrySet();
        for (Map.Entry<String, Food> entry : entries) {
            String key = entry.getKey();
            Food value = entry.getValue();
            System.out.println(key + "\t" + value);
        }
    }
}
