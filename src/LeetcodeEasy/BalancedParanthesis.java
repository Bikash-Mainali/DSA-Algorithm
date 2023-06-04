package LeetcodeEasy;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 8/19/22
 */
public class BalancedParanthesis {
    public static void main(String[] args) {
        String s = "{{{{()}}}}";
        String st = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                st += s.charAt(i);
            }
            if (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') {
                if (st.length() != 0) {
                    if (st.length() != 0) {
                        if (s.charAt(s.length() - 1) == s.charAt(i)) {
                            st = st.substring(0, st.length() - 1);
                        }
                    }
                } else {
                    System.out.println("false");
                    break;
                }
            }
        }
        if (st.length() == 0) {
            System.out.println("true");
        }
    }
}
