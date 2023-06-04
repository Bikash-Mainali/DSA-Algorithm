package LeetcodeEasy;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/13/23
 */
public class PlusOne_66 {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int a[] = {8,9,9,9};
        System.out.println(Arrays.toString(PlusOne_66.plusOne(a)));
    }
}
