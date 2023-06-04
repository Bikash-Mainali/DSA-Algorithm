package LeetcodeMedium;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/12/23
 */
public class Question {
    public static boolean rotateString(String s, String goal) {
        boolean result = false;
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0); //abcde => bcde
            if (s.equals(goal)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Question.rotateString("abcde", "abced"));
    }
}
