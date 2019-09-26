package dxc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/22 17:35
 */
class A{
    public static int mm = 2;
    public int aa = 0;
    public A() {
    }
}

public class Test {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        a1.mm = 5;
        System.out.println(a2.mm);

        /*Map map = new HashMap();
        String name = "aa";
        String name2 = "bb";
        map.put(name,null);
        map.put(name2,null);

        System.out.println(map);*/
        /*String s = "adfdaf";
        System.out.println(s+1);*/
        /*int sn = 22;
        int n = 0;
        while(true){
            if (sn--<0){
                n++;
                break;
            }
        }
        System.out.println(n);*/
        /*int a =0;
        while (a < 6){
            switch (a){
                case 0:
                case 3:a = a+8;
                case 1:
                case 2:a=a+6;
                default:a = a+5;
            }
        }
        System.out.println(a);*/
    }
}
