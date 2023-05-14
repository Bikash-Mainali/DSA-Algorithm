package LeetcodeEasy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/16/22
 */
public class TwoSumProblem {
    public static void main(String[] args) {
        int []nums = {1,2,3,5,6};
        System.out.println(Arrays.toString(findTwoSum(nums, 3)));
    }

    private static int[] findTwoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            set.add(complement);
        }

        for(int j = 0; j<nums.length; j++){
            int complement = target - nums[j];
            if(set.contains(complement) && set.contains(nums[j])){
                return new int[]{complement, nums[j]};
            }
        }
        System.out.println(set);
        return new int[] {};
    }
}
