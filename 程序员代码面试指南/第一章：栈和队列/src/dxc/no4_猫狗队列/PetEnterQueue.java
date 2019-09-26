package dxc.no4_猫狗队列;

/**
 * @author 灵魂编程者
 * @Title: PetEnterQueue
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/26 12:43
 */
public class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public String getPetType(){
        return this.pet.getType();
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }
}
