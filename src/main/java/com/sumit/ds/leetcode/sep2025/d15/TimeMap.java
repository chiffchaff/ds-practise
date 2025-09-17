package com.sumit.ds.leetcode.sep2025.d15;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.com/problems/time-based-key-value-store/description/
 *
 */
class TimeMapUsingBST{

}
public class TimeMap {

    HashMap<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    /**
     * If M is the number of set function calls,
     * N is the number of get function calls, and
     * L is average length of key and value strings.
     * In the set() function, in each call we store a value at (key, timestamp) location, which takes O(L⋅logM) time as the internal implementation of sorted maps is some kind of balanced binary tree and in worst case we might have to compare logM nodes (height of tree) of length L each with our key.
     * Thus, for M calls overall it will take, O(L⋅M⋅logM) time.
     * Space Complexity
     * In the set() function, in each call we store one value string of length L, which takes O(L) space.
     * @param key
     * @param value
     * @param timestamp
     */
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    /**
     * In the get() function, we will find correct key in our map, which can take O(L⋅logM) time and then use binary search on that bucket which can have at most M elements, which takes O(logM) time.
     * Thus, for N calls overall it will take, O(N⋅(L⋅logM+logM)) time.
     * Space:
     * In the get() function, we are not using any additional space.
     * Thus, for all N calls it is a constant space operation.
     * @param key
     * @param timestamp
     * @return
     */
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeMap = map.get(key);
        if (timeMap == null) {
            return "";
        }
        Integer floorKey = timeMap.floorKey(timestamp);
        if (floorKey == null)
            return "";
        return timeMap.get(floorKey);
    }

    public String[] runTest(String[] operations, String[][] arguments) {
        TimeMap timeMap = null;
        String[] results = new String[operations.length];

        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];
            String[] args = arguments[i];
            switch (operation) {
                case "TimeMap":
                    timeMap = new TimeMap();
                    results[i] = null;
                    break;
                case "set":
                    timeMap.set((String) args[0], (String) args[1], Integer.valueOf(args[2]));
                    results[i] = null;
                    break;
                case "get":
                    results[i] = timeMap.get((String) args[0], Integer.valueOf(args[1]));
                    break;
                default:
                    results[i] = null;
                    break;
            }
        }
        return results;
    }

    @Test
    public void testing() {
        String[] operations = {"TimeMap","set","get","get","set","get","get"};
        String [][] arguments = {{},{"foo","bar","1"},{"foo","1"}, {"foo","3"},{"foo","bar2","4"},{"foo","4"},{"foo","5"}};
        String[] expected = new String[]{null, null, "bar", "bar", null, "bar2", "bar2"};
        String[] results = runTest(operations, arguments);
        System.out.println(Arrays.toString(results));
        Assert.assertArrayEquals(expected, results);
    }
}


