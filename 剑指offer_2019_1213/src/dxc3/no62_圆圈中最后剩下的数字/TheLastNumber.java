package dxc3.no62_圆圈中最后剩下的数字;

import dxc.Node;

/**
 * @author dxc
 * @Title: TheLastNumber
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2020/2/24 20:48
 */
/*
* 题目：0，1，。。。n-1这n个数字排成一个圆圈，
* 从数字0开始，每次从这个圆圈里删除第k个数字，
* 求圆圈里剩下的最后一个数字；
* */
public class TheLastNumber {
    /*
    * 实现思路：利用环形链表实现;
    * */
    public static void getLastNumber(int total,int k){

        if (total < 1 || k < 1){
            return;
        }
        Node pre = null;
        Node head = null;
        for (int i = 0;i < total; i++){
            Node newNode = new Node(i);
            if (pre != null){
                pre.next = newNode;
                pre = newNode;
            }else {
                pre = newNode;
                head = newNode;
            }
        }
        //刚好首尾相连；
        pre.next = head;
        //现在开始删除
        int count = 1;
        while (head.next != head){
            count++;
            if (count == k){
                System.out.println(head.next.value);
                count = 1;
                head.next = head.next.next;
                head = head.next;
            }else {
                head = head.next;
            }

        }

        System.out.println("最后剩下："+head.value);
    }

}










