package LeetcodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/12/23
 */

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example:
 * Input: s = "abcabcbb"  //
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        List<Character> longest = new ArrayList<>();
        List<Character> longestCharacterList = new ArrayList<>();
        int totalCharacter = 0;
        char charArr[] = s.toCharArray();
        int startPoint = 0;
        for (int i = startPoint; i < charArr.length;) {
            if (!longest.contains(charArr[i])) {
                longest.add(charArr[i]);
                i++;
            } else {
                i = startPoint++;
                if(longest.size() > totalCharacter) {
                    totalCharacter = longest.size();
                    longestCharacterList.clear();
                    longestCharacterList.addAll(longest);
                }
                longest.clear();
            }
        }
        if(longest.size() > totalCharacter) {
            totalCharacter = longest.size();
            longestCharacterList.clear();
            longestCharacterList.addAll(longest);
        }
        System.out.println(longestCharacterList);
        return totalCharacter;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubString.lengthOfLongestSubstring("pwwkew"));
    }
}
