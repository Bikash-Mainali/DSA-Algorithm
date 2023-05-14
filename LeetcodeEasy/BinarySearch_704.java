package LeetcodeEasy;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 8/22/22
 */
public class BinarySearch_704 {


    public static int solution(int arr[], int left, int right, int x) {

        if (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (x < arr[mid]) {
                //search to the left
                return solution(arr, left, mid - 1, x);
            } else {
                //search to the right
                return solution(arr, mid + 1, right, x);
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int arr[] = {2, 3, 4, 10, 40};
        int x = 10;
        System.out.println(solution(arr, 0, arr.length - 1, x));
    }
}
