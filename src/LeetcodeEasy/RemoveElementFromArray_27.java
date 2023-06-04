package LeetcodeEasy;

import java.util.Arrays;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/13/23
 */
public class RemoveElementFromArray_27 {
    public static int removeElement(int[] nums, int val) {
        int k = 0;  // number of elements not equal to val
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 2, 3, 4};
        int val = 2;
        System.out.println(RemoveElementFromArray_27.removeElement(a, val));
    }
}
