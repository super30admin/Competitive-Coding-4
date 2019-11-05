/**
Daily Problem #56
Time Complexity : O(N^2)
Space Complexity : O(NM)? 
Did this code successfully run on Leetcode : Yes 
Any problem you faced while coding this: 
    I didn't remember how to traverse a binary tree so I had to google it
    Once I refreshed my memory I was able to come up with a solution that used recursion
    It took me some debugging but my solution was able to pass all test cases
    I spent about 1 hour to get the final solution
 */

import java.util.ArrayList;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstLevel = new ArrayList<>();
        
        firstLevel.add(root.val);
        result.add(firstLevel);        
        if(root.left == null && root.right == null){
            return result;
        }
                
        List<List<Integer>> leftResult = levelOrder(root.left);
        List<List<Integer>> rightResult = levelOrder(root.right);
        
        int numLevel = Math.max(leftResult.size(), rightResult.size());
        for(int i =0; i < numLevel; i++) {
            if(i < leftResult.size() && i < rightResult.size()) {
                List<Integer> leftLevel = leftResult.get(i);
                List<Integer> rightLevel = rightResult.get(i);
                //add the right node values to the left node value list
                for(int j = 0; j < rightLevel.size(); j++){
                    leftLevel.add(rightLevel.get(j));
                }
                result.add(leftLevel);    
            }
            // if i exceeds the number of levels on left side
            else if(i < leftResult.size()){
                result.add(leftResult.get(i));
            }
            // if i exceeds the number of levels on right side
            else if(i < rightResult.size()) {
                result.add(rightResult.get(i));
            }
            
        }
        
        return result;
    }