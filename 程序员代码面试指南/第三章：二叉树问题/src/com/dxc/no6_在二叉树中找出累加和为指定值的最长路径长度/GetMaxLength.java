package com.dxc.no6_在二叉树中找出累加和为指定值的最长路径长度;

import com.dxc.Node;

import java.util.HashMap;


/**
 * @author 灵魂编程者
 * @Title: GetMaxLength
 * @Description: 天下风云出我辈，一入代码岁月催，
 * --------------皇图霸业谈笑中，不胜编程一场醉。
 * @date 2019/12/3 22:12
 */

/*
*  思路：类比数组问题中的“给定一个无序数组和一个数k，找出数组中累加和为k的最长子数组
*  并且返回它的长度”；
*
*  实现思路差不多一样，使用一个map键值对集合来保存对应的某一个点之前的所有子数组的和的情况
*  不过二叉树最长路径，map中第一个put进去的简直对是(0,0),表示的就是不用包括任何节点就可以得到这个记录；
*  ;数组中的是(0,-1);
*  实现思路就是递归的实现，传入的参数分别为map，sum，当前的层数level，当前层节点之前的路径和preSum，
*  记录最长路径长度的变量maxLength；
* */
public class GetMaxLength {

    public static int getMaxLength(Node head,int k){
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0,0);
        int maxLength = preOrder(head,sumMap,k,1,0,0);
        return maxLength;
    }

    public static int preOrder(Node head,HashMap<Integer,Integer> sumMap,int k,int level,int preSum,int maxLength){
        if (head == null){
            return maxLength;
        }
        int curSum = preSum + head.value;
        if (!sumMap.containsKey(curSum)){
            sumMap.put(curSum,level);
        }
        if (sumMap.containsKey(curSum - k)){
            maxLength = (level - sumMap.get(curSum - k)) > maxLength ? (level - sumMap.get(curSum - k)) : maxLength;
        }
        maxLength = preOrder(head.left,sumMap,k,level+1,curSum,maxLength);
        maxLength = preOrder(head.right,sumMap,k,level+1,curSum,maxLength);

        //前面递归回来之后，删除本层加入sumMap中的键值对；
        //这里我没看懂为什么要删除本层的这个键值对：
        if (level == sumMap.get(curSum)){
            sumMap.remove(curSum);
        }
        return maxLength;
    }
}
