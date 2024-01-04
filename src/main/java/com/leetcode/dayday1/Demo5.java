package com.leetcode.dayday1;

/**
 * [*接雨水*：
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * ]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/23 20:35]
 */
public class Demo5 {
    public static void main(String[] args) {
        int[] arrays = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};//6
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.trap(arrays));
    }
}

/**
 * 按列求+动态规划
 * 按列求：
 * 求每一列的水，我们只需要关注当前列，以及左边最高的墙，右边最高的墙就够了。
 * 装水的多少，当然根据木桶效应，我们只需要看左边最高的墙和右边最高的墙中较矮的一个就够了。
 * 所以，根据较矮的那个墙和当前列的墙的高度可以分为三种情况：
 *      *较矮的墙的高度大于当前列的墙的高度
 *          正在求的列会有多少水？
 *          很明显，较矮的一边减去当前列得高度就可以了
 *      *较矮的墙的高度小于当前列的墙的高度
 *          正在求的列不会有水，因为它大于了两边较矮的墙
 *      *较矮的墙的高度等于当前列的墙的高度
 *          正在求的列不会有水，因为它等于了两边较矮的墙
 */
class Solution5 {
    public int trap(int[] height) {
        //接雨水的总量
        int sum = 0;
        //当前柱左最大值
        int leftMax = 0;
        //当前柱右最大值
        int rightMax = 0;
        int[] leftMaxArray = new int[height.length];
        int[] rightMaxArray = new int[height.length];
        //遍历数组，找出当前柱子左边的最大值
        for (int i = 0; i < height.length; i++) {
            //如果当前柱子的高度大于当前柱子左边的最大值，那么当前柱子左边的最大值就是当前柱子的高度
            if (height[i] > leftMax) {
                leftMax = height[i];
            }
            //将当前柱子左边的最大值存储到数组中
            leftMaxArray[i] = leftMax;
        }
        //遍历数组，找出当前柱子右边的最大值
        for (int i = height.length - 1; i >= 0; i--) {
            //如果当前柱子的高度大于当前柱子右边的最大值，那么当前柱子右边的最大值就是当前柱子的高度
            if (height[i] > rightMax) {
                rightMax = height[i];
            }
            //将当前柱子右边的最大值存储到数组中
            rightMaxArray[i] = rightMax;
        }
        //遍历数组，计算接雨水的总量
        for (int i = 0; i < height.length; i++) {
            //如果当前柱
            int min = Math.min(leftMaxArray[i], rightMaxArray[i]);
            if (min > height[i]) {
                //接雨水的总量 = 前面接雨水的总量 + 当前柱子左右两边最大值中的最小值 - 当前柱子的高度
                //当前柱子左右两边最大值中的最小值 - 当前柱子的高度 = 当前柱子上能接的雨水量
                sum += min - height[i];
            }
        }
        return sum;
    }
}

/**
 * 解法二：按行求
 * 就是先求高度为 1 的水，再求高度为 2 的水，再求高度为 3 的水。
 * 整个思路就是，求第 i 层的水，遍历每个位置，如果当前的高度小于 i，并且两边有高度大于等于 i 的，说明这个地方一定有水，水就可以加 1。
 * 如果求高度为 i 的水，首先用一个变量 temp 保存当前累积的水，初始化为 0。从左到右遍历墙的高度，遇到高度大于等于 i 的时候，开始更新 temp。
 * 更新原则是遇到高度小于 i 的就把 temp 加 1，遇到高度大于等于 i 的，就把 temp 加到最终的答案 sun 里，并且 temp 置零，然后继续循环。
 */
class Solution5_1{
    public int trap(int[] height) {
        int sum = 0;
        //找到最大的高度，以便遍历。
        int max = getMax(height);
        //从 1 开始遍历,因为最左边和最右边的位置不会有水
        for (int i = 1; i <= max; i++) {
            //标记是否开始更新 temp
            boolean isStart = false;
            int temp = 0;
            //开始遍历墙的高度,求出第 i 层的水,遍历每个位置,如果当前的高度小于 i,并且两边有高度大于等于 i 的,说明这个地方一定有水,水就可以加 1
            for (int h : height) {
                if (isStart && h < i) {
                    temp++;
                }
                //遇到高度大于等于 i 的,就把 temp 加到最终的答案 sun 里,并且 temp 置零,然后继续循环
                if (h >= i) {
                    sum = sum + temp;
                    temp = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }
    /**
     * 找到最大的高度,以便遍历
     */
    private int getMax(int[] height) {
        int max = 0;
        for (int h : height) {
            if (h > max) {
                max = h;
            }
        }
        return max;
    }
    // 作者：windliang
    // 链接：https://leetcode.cn/problems/trapping-rain-water/solutions/9112/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}


/**
 * 解法四：双指针
 * 动态规划中，我们常常可以对空间复杂度进行进一步地优化。
 * 例如这道题中，可以看到，max_left [ i ] 和 max_right [ i ] 数组中的元素我们其实只用一次，然后就再也不会用到了。
 * 所以我们可以不用数组，只用左、右指针就行了。
 */
class Solution5_2{
    public int trap(int[] height) {
        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;
        // 加左指针进去
        int left = 1;
        // 加右指针进去
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更,左指针进去,右指针不变
            if (height[left - 1] < height[right + 1]) {
                //更新左边最大值
                maxLeft = Math.max(maxLeft, height[left - 1]);
                int min = maxLeft;
                if (min > height[left]) {
                    //如果左边最大值大于当前值,说明当前值可以接到水
                    sum = sum + (min - height[left]);
                }
                left++;
            } else {
                //从右到左更,右指针进去,左指针不变

                //更新右边最大值
                maxRight = Math.max(maxRight, height[right + 1]);
                int min = maxRight;
                if (min > height[right]) {
                    //如果右边最大值大于当前值,说明当前值可以接到水
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;
    }

    // 作者：windliang
    // 链接：https://leetcode.cn/problems/trapping-rain-water/solutions/9112/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}