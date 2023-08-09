package com.beijing.leetcode.dayday;

import java.util.*;

/**
 * 实现RandomizedSet 类：
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 * @author : [Jiu Meng]
 * @createTime : [2023/7/4 9:45]
 */
public class demo6 {
}

class RandomizedSet {

    List<Integer> list = new ArrayList();
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();

    /**
     * 在此处初始化您的数据结构
     */
    public RandomizedSet() {

    }

    /**
     * 在集合中插入一个值。如果集合尚未包含指定的元素，则返回true
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * 从集合中删除一个值。如果集合包含指定的元素，则返回true
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(idx, last);
        list.remove(list.size() - 1);
        map.put(last, idx);
        map.remove(val);
        return true;
    }

    /**
     * 从集合中获取一个随机元素
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}