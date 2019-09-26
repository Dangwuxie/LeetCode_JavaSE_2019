package dxc.no4_猫狗队列;

/**
 * @author 灵魂编程者
 * @Title: Pet
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/26 12:25
 */
/*
* 题目要求：使用下面三个类，实现猫狗队列，
* 实现的方法：
* add:放入dog或者cat实例
* pollAll：按照入队先后顺序出队所有动物实例
* pollDog:
* pollCat:
* isEmpty:
* isDogEmpty:
* isCatEmpty:
* 实现思路，可以写一个Pet队列。根据使用Pet的引用接收子类的对象，
* 判断是dog或者是cat，加进两个队列中，加上入队次序，保证出队时的顺序
*
* */
public class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Dog extends Pet{
    public Dog() {
        super("dog");
    }
}
class Cat extends Pet{
    public Cat() {
        super("cat");
    }
}