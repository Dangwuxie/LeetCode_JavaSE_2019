import java.util.HashSet;

/**
 * @author Dangxuchao
 * @Title: Test
 * @ProjectName 第九章：其他问题
 * @Description: TODO
 * @date 2019/6/30 18:56
 */
public class Test {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        System.out.println(set.add("123"));
        System.out.println(set.add("123"));
        /*
        true
        false
         */
    }
}
