package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/#/description
 */
public class L20170412_RandomizedSet {

    private final HashMap<Integer, Integer> location;
    private final ArrayList<Integer> nums;

    /** Initialize your data structure here. */
    public L20170412_RandomizedSet() {
        nums = new ArrayList<>();
        location = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (location.containsKey(val)) {
            return false;
        }
        nums.add(val);
        location.put(val, nums.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!location.containsKey(val)) {
            return false;
        }

        Integer index = location.get(val);
        Integer last = nums.get(nums.size() - 1);
        nums.set(index, last);
        location.put(last, index);

        location.remove(val);
        nums.remove(nums.size() - 1);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int i = random.nextInt(nums.size());
        return nums.get(i);
    }
}

