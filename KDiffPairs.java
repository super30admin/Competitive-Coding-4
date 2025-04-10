// Time complexity:- O(n)
// Space complexity:- O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach:
 * This problem is about finding the number of unique k-diff pairs in an array, where the absolute difference between two numbers is equal to k.
 * I used a HashMap to store the frequency of each number in the array. The map helps in checking if the number + k exists in the array.
 * If k == 0, I check for numbers that appear more than once. If k > 0, I check if num + k exists in the map.
 * Finally, I return the total count of valid pairs.
 */
class Solution {
    public int findPairs(int[] nums, int k) {
        // If k is negative, return 0 as absolute difference cannot be negative
        if (k < 0) return 0;

        // Map to store the frequency of each number
        Map<Integer, Integer> map = new HashMap<>();
        
        // Count the frequency of each element in the array
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int count = 0;
        
        // Iterate over each unique number in the map
        for (int num : map.keySet()) {
            // Case 1: For k = 0, we need to find numbers with at least two occurrences
            if (k == 0) {
                if (map.get(num) > 1) {
                    count++;
                }
            }
            // Case 2: For k > 0, check if num + k exists in the map (find unique pairs)
            else {
                if (map.containsKey(num + k)) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
