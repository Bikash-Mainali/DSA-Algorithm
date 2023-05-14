package LeetcodeMedium;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 5/12/23
 */

import java.util.*;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 */
public class FindMoreThan {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int frequency = nums.length / 3;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer item : nums) {
            if (frequencyMap.containsKey(item)) {
                frequencyMap.put(item, frequencyMap.get(item) + 1);
            } else {
                frequencyMap.put(item, 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = frequencyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next= iterator.next();
            int freq = next.getValue();
            int item = next.getKey();
            if (freq > frequency) {
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n[] = {1,1};
        System.out.println(FindMoreThan.majorityElement(n));
    }
}
