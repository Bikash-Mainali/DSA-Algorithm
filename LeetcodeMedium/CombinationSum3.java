package LeetcodeMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 8/29/22
 */
public class CombinationSum3 {
    static List<List<Integer>> result = new ArrayList();
    public static void main(String[] args) {
        System.out.println(combinationSum3(3,8));
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> combination = new ArrayList();
        try_combination(combination, k, n, 1);
        return result;
    }
    static void try_combination(List<Integer> combination, int k, int n, int start){
        if(k == combination.size()){
            if(n == 0){
                result.add(new ArrayList<>(combination)); // deep copy as it is modified every time
            }
            return;
        }
        for(int i = start; i <= n; ++i){
            combination.add(i);
            try_combination(combination, k, n-i, i+1);
            combination.remove(combination.size() - 1); //backtracking
        }
    }
}








