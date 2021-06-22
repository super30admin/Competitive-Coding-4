package CompetitiveCoding4;

/*Time complexity : o(n*n) 
space complexity: o(1) 
Did this code run successfully in leetcode : yes
problems faces : No.
*/

class Solution {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        
         return Math.abs(leftHeight-rightHeight) < 2
                    && isBalanced(root.left)
                        && isBalanced(root.right);     
    }
    
    private int findHeight(TreeNode root){
        if(root == null) return -1;
        
        return 1+ Math.max(findHeight(root.left), findHeight(root.right));
    }
}

