package dxc.no4_猫狗队列;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/22 17:17
 */
public class Test {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Cat cat1 = new Cat();
        Dog dog2 = new Dog();
        Cat cat2 = new Cat();
        CatDogQueue catDogQueue = new CatDogQueue();
        catDogQueue.add(dog1);
        catDogQueue.add(cat1);
        catDogQueue.add(cat2);
        System.out.println(catDogQueue.pollAll().getType());
        System.out.println(catDogQueue.pollAll().getType());
        System.out.println(catDogQueue.pollAll().getType());
        System.out.println(catDogQueue.pollAll().getType());

    }
}
