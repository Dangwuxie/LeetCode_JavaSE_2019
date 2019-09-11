package dxc.no2_isRotation;

/**
 * @author 灵魂编程者
 * @Title: IsRotation
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/9/10 23:11
 */
/*
* 判断两个字符串是否互为旋转词
* 比如"1234"/"4123"."123a"/"3a12"."1ab2"/"ab21"
* */
public class IsRotation {
    public static void main(String[] args) {
        String a = "";
        String b = " ";
    }

    public static boolean isRotation(String a,String b){
        if (a==null && b==null && a.length()!=b.length()){
            return false;
        }
        //
        String stringNum = b+b;
        //此时可以调用KMP算法来判断此字符串中是否有a字符串
        //有的话就返回true
        return true;
    }

}
