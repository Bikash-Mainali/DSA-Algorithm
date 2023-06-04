package LeetcodeEasy;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/13/23
 */
public class FindInsertPosition_35 {
    public static int searchInsert(int[] nums, int target) {
        int result = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(target < nums[0]){
                result =  0;
                break;
            }
            else if(target < nums[i] || target == nums[i]){
                result = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = {0,2,4,5};
        int target = 4;
        System.out.println(FindInsertPosition_35.searchInsert(a, target));

    }
}
