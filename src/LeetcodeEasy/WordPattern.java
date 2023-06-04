package LeetcodeEasy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/16/22
 */
public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abbb";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {


        String []arr=s.split(" ");
        if(arr.length!=pattern.length())
            return false;
        HashMap<Character,String> map=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            char temp=pattern.charAt(i);
            if(map.containsKey(temp))
            {
                if(!map.get(temp).equals(arr[i]))
                    return false;
            }
            else if(set.contains(arr[i]))
                return false;
            else
            {
                set.add(arr[i]);
                map.put(temp,arr[i]);
            }
        }
        return true;

    }



//        for (int i = 0; i < pattern.length(); i++) {
//            if (i != pattern.length() - 1 && i < pattern.length() - 1) {
//                if (pattern.charAt(i) == pattern.charAt(i + 1)) {
//                    if (i < string.length - 1) {
//                        if (!string[i].equals(string[i + 1])) {
//                            result = false;
//                            break;
//                        }
//                    }
//                    result = true;
//                }
//            } else {
//                if (pattern.charAt(i) == pattern.charAt(i - 1)) {
//                    if (!string[i].equals(string[i - 1])) {
//                        result = false;
//                        break;
//                    }
//                }
//                else if (string[i].equals(string[i - 1])) {
//                    result = false;
//                    break;
//                }
//               // result = true;
//
//            }
//        }
}
