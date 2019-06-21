/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName 6.13 漫算：如何求出最大公约数
 * @Description: TODO
 * @date 2019/6/21 20:37
 */
public class Test {
    public static void main(String[] args) {
        String bigNumberA = "11112222333344445";
        String bigNumberB = "1111222233334445";
        //首先把两个大整数用数组逆序存起来；数组长度等于较大整数长度加1；

        int maxLength = bigNumberA.length()>bigNumberB.length()?bigNumberA.length():bigNumberB.length();

        int[] arrA = new int[maxLength+1];
        for (int i = 0;i < bigNumberA.length();i++){
            arrA[i] = bigNumberA.charAt(bigNumberA.length()-1-i) - '0';
        }

        int[] arrB = new int[maxLength+1];
        for (int i = 0;i < bigNumberB.length();i++){
            arrB[i] = bigNumberB.charAt(bigNumberB.length()-1-i) - '0';
        }
        //result长度加一，因为A、B相加完后可能会进位；

        String result =  BigNumberSum.addBigNumber(arrA,arrB);

        System.out.println(result);


    }
}
