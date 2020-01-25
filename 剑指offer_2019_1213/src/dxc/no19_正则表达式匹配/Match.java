package dxc.no19_正则表达式匹配;

/**
 * @author dxc
 * @Title: Match
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/1/25 19:21
 */
public class Match {

    public static boolean match(char[] str,char[] pattern){

        if (str == null || pattern == null){
            return false;
        }

        return matchCore(str,pattern,0,0);
    }

    private static boolean matchCore(char[] strs,char[] pattern,int s,int p){

        if (s == strs.length && p >= pattern.length){
            return true;
        }
        //当pattern中当前字符的下一个是*时，多种情况
        if (p < pattern.length-1 && pattern[p + 1] == '*'){
            //此时要考虑多种情况
            if (pattern[p] == strs[s] || pattern[p] == '.'){
                //将*前面的字符当作1个字符，两个字符串同时前进到下一个字符
                return matchCore(strs,pattern,s+1,p+2)
                        //将*前面的字符当作多个字符，继续对比，strs的下标继续前进
                        || matchCore(strs,pattern,s+1,p)
                        //将*前面的字符当做空字符处理，与下一个字符对比，strs不变；
                        || matchCore(strs,pattern,s,p+2);
            }else {
                //直接将*前面的字符当空，pattern下标加2
                //与前面的if语句中的第三种条件差不多相同；
                return matchCore(strs,pattern,s,p+2);
            }
        }

        if (pattern[p] == strs[s] || pattern[p] == '.'){
            return matchCore(strs,pattern,s+1,p+1);
        }

        return false;
    }
}
