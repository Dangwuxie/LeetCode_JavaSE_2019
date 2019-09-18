package dxc.no1_exchange;

/**
 * @author 灵魂编程者
 * @Title: Exchange
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/18 11:15
 */
/*
* 通过位运算交换两个变量的值
* */
public class Exchange {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a"+a);
        System.out.println("b"+b);

    }
}
