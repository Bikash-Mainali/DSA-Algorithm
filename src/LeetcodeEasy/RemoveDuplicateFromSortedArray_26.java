package LeetcodeEasy;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/13/23
 */
public class RemoveDuplicateFromSortedArray_26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int a[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(RemoveDuplicateFromSortedArray_26.removeDuplicates(a));

    }
}

