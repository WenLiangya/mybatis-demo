package com.beijing.leetcode.dayday;

/**
 * [一句话描述该类功能]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/2 21:27]
 */
public class demo5 {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 1, 4, 2, 2, 1, 1, 1, 1, 3, 2, 3, 1, 1};
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.jump(array));
    }
}

class Solution5 {
    public int jump(int[] nums) {
        int jumps = 0;
        //能到达所需要的步数
        int curEnd = 0;
        //在当前步数能到达的最远的地方
        int curFarthest = 0;
        //走在路程中发现能到达的新的最远处

        //例如你从0开始往后跳，能跳到最远的地方是3，那么在你走到3之前都算是第一步
        //往后走的时候你发现，从2可以跳到7，从3只能跳到6，那么你第二步的最远就是7
        //你的跳跃路径应该是0->2->7

        for (int i = 0; i < nums.length - 1; i++) {
            //这里是< nums.length - 1
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                //当我们走到了这一步能到达的最远处，要开始新的一步了
                jumps++;
                curEnd = curFarthest;
                //更新下一步的最远点
                if (curEnd >= nums.length - 1) {
                    break;
                    //直接退出，因为我们在0=0的时候率先加了一步上去
                }
            }
        }

        return jumps;
    }
}