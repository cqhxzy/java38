package room2;

public class Test4 {

    //类中也可以声明类，称为类的内部类
    public class Cat{
        public Cat(String name,char sex){
            this.name = name;
            this.sex = sex;
        }
        public String name;
        public char sex;

        /**
         * 打印猫信息的方法
         */
        public void print(){
            //Cat[name=tom,sex=雄]
            System.out.println(this + "    Cat[name="+this.name+",sex="+this.sex+"]");
        }
    }

    public void change(Cat cat){
        cat.name = "加菲猫";
        cat.sex = '雌';
    }

    public static void main(String[] args) {
        //内部类对象的创建必须依赖外部类的对象，除非内部类是一个静态的
        Test4 t4 = new Test4();
        Cat cat = t4.new Cat("Tom",'雄');
        //打印cat的内容
        cat.print();

        t4.change(cat);
        cat.print();
    }
}
