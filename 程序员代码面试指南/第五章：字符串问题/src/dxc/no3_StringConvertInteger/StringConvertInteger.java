package dxc.no3_StringConvertInteger;

/**
 * @author 灵魂编程者
 * @Title: StringConvertInteger
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/11 0:20
 */
/*
* 将整数字符串转换为整数值，32位整数的范围
* 注意：负数也要考虑进去
* 1、不以负号开头，也不以数字开头，就返回false
* 2、以负号开头，但是只有一个负号，或者后面跟的第一个是0或者非数字，返回false
* 3、没有负号，以0开头并且长度大于1的，返回false，就一个0的话是可以的；
*   然后就是转换了，思路，32位是-2147483648---2147483647
*   所以一律按照负数比较，然后最后加个符号标志就行
*
* */
public class StringConvertInteger {
    public static void main(String[] args) {
        String str = "-023456";
        if (isValid(str)){
            System.out.println("111");
            System.out.println(convert(str));
        }
    }

    public static boolean isValid(String str){
        if (str == null || str.equals("")){
            System.out.println("字符串为空");
            return false;
        }else {
            char[] chars = str.toCharArray();
            //此处就需要判断了
            //1、不以负号开头，也不以数字开头，就返回false
            if (chars[0]!='-' && (chars[0]>'9'||chars[0]<'0'))return false;
            //2、以负号开头，但是只有一个负号，或者后面跟的第一个是0或者非数字，返回false
            if (chars[0]=='-' &&
                    (chars.length==1 || chars[1]=='0')) return false;

            //3、没有负号，以0开头并且长度大于1的，返回false，就一个0的话是可以的；
            if (chars[0]=='0' && chars.length>1) return false;
            //4、遍历字符串，[1...n-1]是不是都是数字，如果是，返回true，否则false
            for (int j=1;j<chars.length;j++){
                if (chars[j]>'9' || chars[j]<'0')return false;
            }
        }
        return true;
    }

    public static int convert(String str){
        char[] chars = str.toCharArray();
        //先加个标志，
        boolean sign = chars[0] == '-'?false:true;
        //使用最小值，定义一个除数跟余数，后面需要比较是否数值溢出
        int a = Integer.MIN_VALUE/10;
        int b = Integer.MIN_VALUE%10;
        //num记录str转过来的数字
        int num = 0;
        //当前数字的负数形式
        int cur = 0;
        //sign是false代表负数
        for (int i = sign?0:1;i<chars.length;i++){
            cur = '0'-chars[i];//把当前的数字变成负的整形数字
            //判断一下，最后接近Integer最小值的时候会不会溢出
            if (num<a || (num==a && cur<b))return 0;
            num = num*10+cur;
        }

        //32位是-2147483648---2147483647，
        // 负数的绝对值比整数的绝对值大1，此处再判断一下特殊情况
        //sign为true的时候代表没有“-”
        if (sign&&num==Integer.MIN_VALUE){
            return 0;
        }
        return sign?-num:num;
    }
}
