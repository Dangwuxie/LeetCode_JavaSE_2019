package dxc.no4_猫狗队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 灵魂编程者
 * @Title: CatDogQueue
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/26 12:45
 */
public class CatDogQueue {
    private Queue<PetEnterQueue> catQ;
    private Queue<PetEnterQueue> dogQ;
    private long count;

    public CatDogQueue() {
        this.catQ = new LinkedList<>();
        this.dogQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet){
        if (pet.getType().equals("dog")){
            this.dogQ.add(new PetEnterQueue(pet,this.count++));
        }else if (pet.getType().equals("cat")){
            this.catQ.add(new PetEnterQueue(pet,this.count++));
        }else {
            System.out.println("错误，无法入队！");
        }
    }

    public Pet pollAll(){
        if (!catQ.isEmpty() && !dogQ.isEmpty()){
            return this.dogQ.peek().getCount()<this.catQ.peek().getCount()?
                    this.dogQ.poll().getPet():this.catQ.poll().getPet();
        }else if (!this.dogQ.isEmpty()){
            return this.dogQ.poll().getPet();
        }else if (!this.catQ.isEmpty()){
            return this.catQ.poll().getPet();
        }else {
            System.out.println("输出错误");
        }
        return null;
    }

    public Dog pollDog(){
        if (!this.dogQ.isEmpty()){
            //此处需要强转
            return (Dog) this.dogQ.poll().getPet();
        }
        return null;
    }

    public Cat pollCat(){
        if (!this.catQ.isEmpty()){
            return (Cat) this.catQ.poll().getPet();
        }
        return null;
    }
}





















