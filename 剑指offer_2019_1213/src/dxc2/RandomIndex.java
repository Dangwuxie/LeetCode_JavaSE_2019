package dxc2;

import java.util.Random;

/**
 * @author dxc
 * @Title: RandomIndex
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/11 13:25
 */
public class RandomIndex {

    public static int randomIndex(int l,int r){
        //l-r之间的数字
        return (int) (Math.random() * (r - l + 1)) + l;
    }

}
