// Time complexity:- O(n2)
// Space complexity:- O(n2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach:
 * This problem is about generating Pascal's Triangle for a given number of rows. I used a dynamic approach where each row is constructed based on the previous row.
 * The Pascal's triangle is initialized with the first row, which contains only the number '1'.
 * For each subsequent row, I start with '1'at the beginning, then calculate the inner elements as the sum of the two elements directly above from the previous row.
 * Each row ends with '1', and the row is then added to the result list.
 * This process is repeated for the given number of rows (numRows) and the entire Pascal's triangle is returned.
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        // Create a list to store the rows of Pascal's Triangle
        List<List<Integer>> list = new ArrayList<>();

        // Initialize the first row with a single element 1
        ArrayList<Integer> rows1 = new ArrayList<>();
        rows1.add(1);

        // Add the first row to the list
        list.add(rows1);
        
        // Loop to generate each subsequent row
        for(int i = 1; i < numRows; i++) {
            // Create a new list for the current row
            ArrayList<Integer> rowsList = new ArrayList<>();

            // The first element of each row is always 1
            rowsList.add(1);

            // Calculate the inner elements of the row by summing adjacent elements from the previous row
            for(int j = 1; j < i; j++ ) {
                rowsList.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));               
            }
            // The last element of each row is always 1
            rowsList.add(1);
            // Add the current row to the list
            list.add(rowsList);

        }
        
        return list;      
    }
}