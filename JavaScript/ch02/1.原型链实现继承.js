function Person(name,age){
    this.name = name;
    this.age = age;
    this.play = [1,2,3];
    this.setName = function(name){
        this.name = name;
    }
}

Person.prototype.getAge=function(){
    return this.age;
}

function Student(){

}

//第一种方式：
var p1 = new Person('张三',18);
Student.prototype = p1;

var stu1 = new Student();
stu1.setName("ttt");
var stu2 = new Student();
console.log(stu1.name);
console.log(stu2.name);

