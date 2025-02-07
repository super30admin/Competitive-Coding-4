import java.util.*;

public class PairsWithKDifference {
    public static int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        
        Set<Integer> uniqueNumbers = new HashSet<>();
        Set<Integer> countedPairs = new HashSet<>();
        
        for (int num : nums) {
            if (uniqueNumbers.contains(num - k)) {
                countedPairs.add(num - k);
            }
            if (uniqueNumbers.contains(num + k)) {
                countedPairs.add(num);
            }
            uniqueNumbers.add(num);
        }
        
        return countedPairs.size();
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 5, 9, 2, 12, 3};
        int k = 2; // Change as needed
        System.out.println("Number of pairs: " + findPairs(nums, k));
    }
}
