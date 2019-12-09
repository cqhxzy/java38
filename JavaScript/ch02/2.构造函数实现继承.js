function Person(name,age){
    this.name = name;
    this.age = age;
    this.play = [1,2,3];
    this.getAge=function(){
        return this.age;
    }
}

Person.prototype.show=function(){}
Person.prototype.id = "";

/*另一个学生的父类 */
function Work(x){
    this.x = x;
}

function Student(name,age,sex){
    //调用父类的构造函数
    Person.call(this,name,age);
    //通过call，可以很容易的实现多继承
    Work.call(this,10);
    this.sex = sex; //Student自己的属性
}

//和java的语法相近，通过子类的构造函数调用父类的构造函数
//父类的原型中定义的属性和方法子类无法获取
var stu = new Student('tom',18,'男');
console.log(stu.sex);