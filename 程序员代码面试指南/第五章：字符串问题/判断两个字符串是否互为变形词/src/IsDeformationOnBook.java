/**
 * @author Dangxuchao
 * @Title: IsDeformationOnBook
 * @ProjectName 第五章：字符串问题
 * @Description: 书上的解法：
 *
 * @date 2019/7/1 18:38
 */
public class IsDeformationOnBook {

    public static void main(String[] args) {
        String str1 = "121122adf@@]]]";
        String str2 = "121122daf@1]]]";

        System.out.println(isDeformation(str1,str2));

    }

    public static boolean isDeformation(String str1,String str2){
        if (str1 == null || str2==null || str1.length() != str2.length()){
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[] map = new int[256];

        for (int i = 0;i < chars1.length;i++){
            map[chars1[i]]++;
        }

        for (int i = 0;i < chars2.length;i++){
            //此处的if语句是这个意思：
            //先判断当前map存储的ASC码坐标处的值是否等于0，
            //如果等于0就要进入if语句，进入之前自减，
            // 如果不等于0就自减1，不进入if语句；
            //先判断，再自减；；
            //很有灵性的一个判断；
            if (map[chars2[i]] -- == 0){
                System.out.println(map[chars2[i]]);
                return false;
            }
        }
        return true;
    }
}
