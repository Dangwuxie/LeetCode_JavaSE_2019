package dxc.no30_包含min函数的栈;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/3 20:36
 */
public class Test {

    public static void main(String[] args) {

        ContainMinStack stack = new ContainMinStack();
        stack.push(5);
        stack.push(2);
        stack.push(4);


        stack.pop();

        stack.getMin();

    }
}
