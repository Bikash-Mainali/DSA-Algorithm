package LeetcodeEasy;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 7/19/22
 */
public class FizzBuzz {
    public static int solution(int[] a) {
        List<Integer> list = Arrays.stream(a).mapToObj(x -> x).collect(Collectors.toList());
        int index = 1;
        int result = 1;
        for(int i = 0; i<list.size(); i++){
            if(!list.contains(index)){
                result =  index;
                break;
            }
            index ++;
            result = index;
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        System.out.println(FizzBuzz.solution(a));
    }
}
