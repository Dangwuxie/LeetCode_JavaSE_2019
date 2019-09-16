package dxc.求一个字符串中的最大数字子串;

/**
 * @author 灵魂编程者
 * @Title: Test2
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/16 19:43
 */
public class Test2 {

    public static void main(String[] args) {
        String res = find_longest_num_str("a123bb1234a");
        System.out.println(res);
    }

    static String find_longest_num_str(String input) {

        char[] arr = input.toCharArray();
        int max = 0;
        int temp = 0;
        int tempi = 0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]>='0'&&arr[i]<='9'){
                temp++;
            }else {
                if (max<temp){
                    tempi = i;
                    max = temp;
                }
                temp = 0;
            }
        }
        char[] tempCh = new char[max];
        int j = tempi-max;
        for (int i=0;i<tempCh.length;i++){
            tempCh[i] = arr[j];
            j++;
        }
        return new String(tempCh);
    }
}
