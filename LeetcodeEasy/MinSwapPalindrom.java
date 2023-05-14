package LeetcodeEasy;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/17/22
 */
public class MinSwapPalindrom {
    static char [] s = new char[]{};

    public static void main(String[] args) {
        System.out.println(solution("0100101"));
    }

    static int solution(String str) {
        int n = str.length();
        char s[] = str.toCharArray();
        int count = 0;
        for(int i =0; i <n/2; i++){
            int left = i;
            int right = n-i-1;
            while(left < right){
                if(s[left] == s[right]) break;
                else right--;
            }
            if(left == right) return -1;
            for(int j=right; j<n-left-1; j++){
                char temp = s[j+1];
                s[j+1] = s[j];
                s[j] = temp;
                count++;
            }
        }
        return count;
    }

}
