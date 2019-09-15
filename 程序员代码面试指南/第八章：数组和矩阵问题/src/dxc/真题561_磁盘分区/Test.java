package dxc.真题561_磁盘分区;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/15 20:47
 */
public class Test {
    public static void main(String[] args) {
        int[] p = {120,120,120};
        int[] q = {60,60,80,80,80};
        if (Allocable.is_allocable(p,q)){
            System.out.println("分配成功");
        }else {
            System.out.println("分配失败");
        }
    }
}
