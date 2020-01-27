package dxc.no20_表示数值的字符串;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/25 20:53
 */
public class Test {

    public static void main(String[] args) {

        String str1 = "+100";
        String str2 = "5e2";
        String str3 = "-123";
        String str4 = "+3.12e-1";

        String str5 = "-1E-2";
        String str6 = "12e";
        String str7 = "1a.32";
        String str8 = "1.2.3";

        String str9 = "+-5";
        String str10 = "12e+5.3";

        System.out.println(IsNumeric.isNumeric(str1));
        System.out.println(IsNumeric.isNumeric(str2));
        System.out.println(IsNumeric.isNumeric(str3));
        System.out.println(IsNumeric.isNumeric(str4));

        System.out.println(IsNumeric.isNumeric(str5));
        System.out.println(IsNumeric.isNumeric(str6));
        System.out.println(IsNumeric.isNumeric(str7));
        System.out.println(IsNumeric.isNumeric(str8));

        System.out.println(IsNumeric.isNumeric(str9));
        System.out.println(IsNumeric.isNumeric(str10));


    }
}
