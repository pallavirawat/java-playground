package LeetCode.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TwoSum {
    int[] memo = new int[50];

    public TwoSum() {
        Arrays.fill(memo, -1);
    }

    public int[] calculate(int[] nums, int target) {
        LinkedList<Integer> list  = new LinkedList<>();
        for(int i=0; i<nums.length; i++){
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    list.push(i);
                    list.push(j);
                }
            }
        }


        Object[] objectAarray = list.toArray();
        int length = objectAarray.length;;
        int [] intArray = new int[length];
        for(int i =0; i < length; i++) {
            intArray[i] = (int) objectAarray[i];
        }
        return intArray;
    }

    public int[] idealcalculate(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
