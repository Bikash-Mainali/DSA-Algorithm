package recursion;

import java.util.Stack;

/**
 * 78. Subsets
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class SubsetProblem {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        findSubsets(arr, 0, new Stack<>());
    }

    private static void findSubsets(int[] arr, int index, Stack<Integer> stack) {
        if (index == arr.length) {
            System.out.println(stack);
            return;
        }
        stack.push(arr[index]);
        findSubsets(arr, index + 1, stack);
        stack.pop();
        findSubsets(arr, index + 1, stack);
    }
}
