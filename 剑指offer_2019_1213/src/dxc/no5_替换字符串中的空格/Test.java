package dxc.no5_替换字符串中的空格;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/16 17:55
 */
public class Test {

    public static void main(String[] args) {

        String str1 = " we are family";
        String str2 = "we are family ";
        String str3 = "wearefamily";
        String str4 = "weare      family";//6
        String str5 = " ";
        String str6 = "";
        String str7 = "      ";//6

        System.out.println(ReplaceString.replaceString(str1));
        System.out.println(ReplaceString.replaceString(str2));
        System.out.println(ReplaceString.replaceString(str3));

        System.out.println(ReplaceString.replaceString(str4));
        System.out.println(ReplaceString.replaceString(str5));
        System.out.println(ReplaceString.replaceString(str6));

        System.out.println(ReplaceString.replaceString(str7));
        /*
        *
          %20we%20are%20family
          we%20are%20family%20
          wearefamily
          weare%20%20%20%20%20%20family
          %20
          null
          %20%20%20%20%20%20
        * */
    }
}
