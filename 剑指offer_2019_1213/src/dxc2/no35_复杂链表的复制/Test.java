package dxc2.no35_复杂链表的复制;

/**
 * @author dxc
 * @Title: Test
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/8 14:08
 */
public class Test {

    public static void main(String[] args) {

        RandNode n1 = new RandNode(1);
        RandNode n2 = new RandNode(2);
        RandNode n3 = new RandNode(3);

        n1.next = n2;
        n2.next = n3;

        n1.sib = n2;
        n2.sib = null;
        n3.sib = n1;

        RandNode res = CopyOfListWithRand.copyOfList(n1);


         for (int i = 0;i < 3; i++){
             System.out.print(res.value+"->");
             if (res.sib != null){
                 System.out.println(res.sib.value);
             }else {
                 System.out.println("null");
             }
             res = res.next;
         }

        /*
        *
        *   1->2
            2->null
            3->1
        * */
    }
}
