package com.beijing.leetcode.dayday2;

/**
 * [*加油站*:
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。给定两个整数数组 gas 和 cost ，
 * 如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/8/9 20:44]
 */
public class Demo6 {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(solution.canCompleteCircuit(gas, cost));

        Solution6_1 solution6_1 = new Solution6_1();
        System.out.println(solution6_1.canCompleteCircuit(gas, cost));
    }
}

/**
 * 暴力解法,双遍历,时间复杂度O(n^2),空间复杂度O(1),超时
 */
class Solution6 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //从第一个加油站开始，如果gas[i] - cost[i] < 0，说明从i出发无法到达i+1，那么从i+1开始
        if (gas.length == 0 || cost.length == 0) {
            return -1;
        }
        if (gas.length == 1) {//只有一个加油站的情况
            if (gas[0] - cost[0] >= 0) {//如果加油站的油量大于等于消耗量，那么可以绕环路行驶一周
                return 0;
            } else {
                return -1;
            }
        }
        for (int i = 0; i < gas.length; i++) {//从第一个加油站开始遍历,判断是否可以绕环路行驶一周
            if (gas[i] - cost[i] < 0) {
                continue;
            }
            int j = i;
            int target = 0;//剩余油量
            while (j < gas.length) {//从i出发，判断是否可以到达i+1
                target += gas[j] - cost[j];
                if (target < 0) {//剩余油量不足，无法到达下一个加油站
                    break;
                }
                j++;
                if (j == gas.length) {//如果到达了最后一个加油站，那么从0开始判断是否可以到达i
                    j = 0;
                }
                if (j == i) {//如果回到了i，说明可以绕环路行驶一周
                    return i;
                }
            }
        }
        return -1;
    }
}

/**
 * 优化,时间复杂度O(n),空间复杂度O(1)
 */
class Solution6_1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0; // 总的剩余油量
        int currentGas = 0; // 当前剩余油量
        int startStation = 0; // 起始加油站位置
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];//总的剩余油量,如果大于等于0，说明可以绕环路行驶一周
            currentGas += gas[i] - cost[i];//当前剩余油量,如果小于0，说明从startStation出发无法到达i+1，那么从i+1开始
            if (currentGas < 0) { // 当前剩余油量不足以到达下一个加油站
                startStation = i + 1; // 更新起始加油站位置
                currentGas = 0; // 重置当前剩余油量
            }
        }
        return totalGas >= 0 ? startStation : -1; // 如果总的剩余油量大于等于0，则返回起始加油站位置，否则返回-1
    }
}