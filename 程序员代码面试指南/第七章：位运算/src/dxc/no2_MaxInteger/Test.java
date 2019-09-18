package dxc.no2_MaxInteger;

/**
 * @author 灵魂编程者
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/18 11:22
 */
public class Test {
    public static void main(String[] args) {
        int a = 7;
        int b = 5;
        System.out.println(getMax(a,b));
    }
    public static int getMax(int a,int b){
        int c = a-b;
        //scA如果是1那么代表a是最大值
        int scA = sign(c);
        //对scA取反，就是0，乘以b就是0；
        int scB = flip(scA);
        return a*scA+b*scB;
    }

    //sign函数的功能就是返回n的符号，
    //正整数和0返回1，负数返回0
    public static int sign(int n){
        return (flip(n>>31)&1);
    }

    //如果o为1返回0，是0返回1；
    public static int flip(int o){
        return o^1;
    }

    /*
    * 改进一下，a-b可能会出现数值溢出，
    * */

    public static int getMax2(int a,int b){
        /*防止溢出*/
        if (sign(a)==1 && sign(b)==0){
            return a;
        }else if (sign(a)==0 && sign(b)==1){
            return b;
        }
        int c = a-b;
        //scA如果是1那么代表a是最大值
        int scA = sign(c);
        //对scA取反，就是0，乘以b就是0；
        int scB = flip(scA);
        return a*scA+b*scB;
    }
}
