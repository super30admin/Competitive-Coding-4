// Time Complexity : O(n)-> where n is number of nodes in Binary tree
// Space Complexity : O(h)-> height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  I was focussing mainly on returning the valid condition and caused a silly error. I should focus on returning false condition.
/* Your code here along with comments explaining your approach: Calculate the height of each and every node to check if the tree is balanced.
The balance condition is that the height of the left subtree of a node and right subtree of a node should be <= 1. If there is violation, return -1,
elsewise return true. We need to call the height function for each and every node to check the validity of a balanced Binary tree.
*/
class Solution {
    /*   RECURISVE
    public boolean isBalanced(TreeNode root) {
      if(root == null){ return true;}
     return height(root) == -1? false : true;                   // If the -1 is returned => false
    }
    private int height(TreeNode root){
        if(root == null){return 0;}
        int left = height(root.left);                           // Check height of left subtree
        int right = height(root.right);                         // Check height of right subtree
        if(Math.abs(left - right) > 1 || left == -1 || right == -1){                // Check if the balanced condition is correct
            return -1;
        }
        return 1 + Math.max(left, right);                       // return the height of the particular node from bottom to top
    } */

            // ITERATIVE 
    class Solution {
    public boolean isBalanced(TreeNode root) {
      if(root == null){ return true;}
      HashMap<TreeNode, Integer> height = new HashMap<>();                  // Store the height of nodes 
      Stack<TreeNode> stk = new Stack<>();                                  // Next node to process in DFS
      stk.push(root);
      int left = 0, right = 0;
      while(!stk.isEmpty())
      { TreeNode node = stk.pop();
        if(node.left != null && !height.containsKey(node.left)){                // Enter the left child and the node itself since, we are missing out the chance of calculating the height of this node without the child's height
            stk.push(node);
            stk.push(node.left);
        } 
       if(node.right != null && !height.containsKey(node.right)){
            stk.push(node);                                             // Push the right child so that its height gets calculated, then parent gets calculated using the child's height values
            stk.push(node.right);
        }
        if(((node.left != null && height.containsKey(node.left)) || (node.left == null)) && ((node.right != null && height.containsKey(node.right)) || (node.right == null))){ // if leaf , its height needs to be calculated on priority
        left = node.left == null ? 0 : height.get(node.left);               // Use the children height to calculate parene height = bottom up approach
        right = node.right == null ? 0 : height.get(node.right);
        if(Math.abs(left - right) > 1) {return false;}                      // Violation condition
        height.put(node, Math.max(left, right) + 1);                            // Height storing for each and every node in a map
        }
    }
    System.out.println(height);
    return true;
}
}
}