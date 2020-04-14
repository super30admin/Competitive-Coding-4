// 110.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//every node returns its height and is balanced or not to its caller
public class returnObject {
    int height;
    boolean isBalanced;
    
    public returnObject(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}

//time - O(n) every noode is touched once
//space - O(h) max recursive stack size is haight of tree


class Solution {
    public boolean isBalanced(TreeNode root) {
        boolean answer = findBalanced(root).isBalanced;
        return answer;
    }
    
    private returnObject findBalanced(TreeNode root)
    {
        //base
        if(root == null)
        {
            return new returnObject(-1, true); //null node has height -1 and is balanced
        }
        
        //logic
        returnObject left = findBalanced(root.left);
        returnObject right = findBalanced(root.right);
        
        int height = Math.max(left.height, right.height) + 1; //height of a node is max of left height and right height plus 1 
        boolean balanced = false;
        if(Math.abs(left.height - right.height) <= 1 && left.isBalanced && right.isBalanced) //a node is balanced if abs(left height - right height) <= 1
        {
            balanced = true;
        }
        
        return new returnObject(height, balanced);
    }
}

// call stack
// fb(3) -> fb(9) -> fb(null) 
//                <- -1, true
//                -> fb(null)
//                <- -1, true
//       <- 0, true
//       -> fb(20) -> fb(15) -> fb(null)
//                           <- -1, true
//                           -> fb(null)
//                           <- -1, true
//                 <- 0, true
//                 -> fb(7) -> fb(null)
//                          <- -1, true
//                          -> fb(null)
//                          <- -1, true
//                 <- 0, true
//       <- 1, true
// <- 2, true    
