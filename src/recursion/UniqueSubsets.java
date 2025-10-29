package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */

class UniqueSubsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // this algorithm works for sorted elements only
        backTrack(nums, new ArrayList<>(), 0, result);
        return result;
    }

    private static void backTrack(int[] nums, List<Integer> current, int index, List<List<Integer>> result) {
        // Base case: if we've processed all elements
        if (index == nums.length) {
            List<Integer> sortedCopy = new ArrayList<>(current);
            Collections.sort(sortedCopy);
            result.add(sortedCopy);
            return;
        }

        // Include current number
        current.add(nums[index]);
        backTrack(nums, current, index + 1, result);


        // Exclude current number
        current.remove(current.size() - 1);
        int idx = index + 1;
        while (idx < nums.length && nums[idx] == nums[idx - 1]) {
            idx++;
        }
        backTrack(nums, current, idx, result);
    }

    // Example run
    public static void main(String[] args) {
        UniqueSubsets sol = new UniqueSubsets();
        System.out.println(sol.subsetsWithDup(new int[]{1, 2, 3}));
    }

}
