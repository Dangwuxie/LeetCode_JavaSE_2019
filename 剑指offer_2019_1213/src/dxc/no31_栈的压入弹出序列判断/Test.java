package dxc.no31_栈的压入弹出序列判断;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/4 17:39
 */
public class Test {

    public static void main(String[] args) {

        String str1 = "12345";
        String str2 = "45321";
        String str3 = "45312";

        System.out.println(IsOrderPop.isOrderPop(str1,str2));
        System.out.println(IsOrderPop.isOrderPop(str1,str3));

    }
}
