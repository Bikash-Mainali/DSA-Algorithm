package LeetcodeEasy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 8/19/22
 */
public class IntegerToRoman {
    public static String convert(int x) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int countOfRoman = x / entry.getValue();
            x = x % entry.getValue();
            if (countOfRoman != 0) {
                if (countOfRoman > 1) {
                    while (countOfRoman > 0) {
                        result.append(entry.getKey());
                        countOfRoman--;
                    }
                } else {
                    result.append(entry.getKey());
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert(43));
    }
}
