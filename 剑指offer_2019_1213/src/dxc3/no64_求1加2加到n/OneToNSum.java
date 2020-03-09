package dxc3.no64_求1加2加到n;

/**
 * @author dxc
 * @Title: OneToNSum
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/25 18:03
 */
public class OneToNSum {

    private static int N;
    private static int sum;

    public OneToNSum() {
        N++;
        sum += N;
    }

    public static int getSum(int m){
        return sum;
    }
}
