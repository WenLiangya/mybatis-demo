package com.leetcode.month10;

import java.util.ArrayDeque;

/**
 * [901. 股票价格跨度：设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 *
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 *
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 *
 * 实现 StockSpanner 类：
 *
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。]
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/10/7 12:57]
 */
public class Demo10_07 {
    //生成测试代码
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}

class StockSpanner {
    private final ArrayDeque<int[]> stack = new ArrayDeque<>();//这是一个单调栈，存放的是价格和跨度
    private int curDay = -1;//当前天数,从0开始,每次next都会加1,所以初始值为-1

    public StockSpanner() {
        //构造函数,初始化
        //哨兵,价格为-1,跨度为无穷大,哨兵的作用是为了让栈不为空,方便后面的peek
        stack.push(new int[]{-1, Integer.MAX_VALUE});
    }

    public int next(int price) {
        while (price >= stack.peek()[1]) {
            //stack.peek()[1]是栈顶元素的价格,如果当前价格大于栈顶元素的价格,就弹出栈顶元素
            stack.pop();
        }
        //当前天数减去栈顶元素的天数,就是跨度,++curDay是因为curDay是从-1开始的,所以要先加1
        int res = ++curDay - stack.peek()[0];
        //将当前价格和跨度入栈
        stack.push(new int[]{curDay, price});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */