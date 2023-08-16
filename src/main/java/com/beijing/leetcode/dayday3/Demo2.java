package com.beijing.leetcode.dayday3;

/**
 * [2682. 找出转圈游戏输家]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/16 20:20]
 */
public class Demo2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] ints = solution.circularGameLosers(5, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

class Solution2 {
    public int[] circularGameLosers(int n, int k) {

        //创建一个boolean类型的数组，用来标记每个人是否出局
        boolean[] flag = new boolean[n];
        int m = n;//m表示剩余的人数
        //遍历flag数组，将每个人的状态初始化为false
        for (int i = 0, d = k; !flag[i]; d += k , m--) {
            //!flag[i]等同于flag[i]==false,表示编号为i+1的人还没有出局
            //d表示每次数的步长,d+=k表示步长每次加k,因为每次数的人都是出局的，所以m--,表示剩余的人数

            //将编号为i+1的人标记为true
            flag[i] = true;
            //如果m==1，说明只剩下一个人了，那么就跳出循环
            i = (i + d) % n;
        }

        //创建一个数组，用来存储输家的编号
        int[] result = new int[m];
        //遍历flag数组，将为false的编号存入result数组中
        for (int i = 0, j = 0; i < n; i++) {
            //如果flag[i]为false，说明编号为i+1的人是输家
            if (!flag[i]) {
                //将i+1存入result数组中
                result[j++] = i + 1;
            }
        }
        return result;
    }
}