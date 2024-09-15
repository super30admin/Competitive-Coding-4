//idea:  //recursive approach

// iterate tree and  calculate height of each parent node from left tree and right tree till we reach leaf node that is null parent node after leaf node. 
//take difference between two height. If it is grater than 1 then return false.

//time complexity o(n) 
//space complexity is o(n) due to recursion internal stack need memory 
////Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:no

//  Definition for singly-linked list.
  class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int value) {
			val = value;
		}
	}
class Solution {
    public static boolean isBalanced(TreeNode root) {
        if(root ==null) return true;
        int leftHeight = FindHeight(root.left);
        int rightHeight = FindHeight(root.right);
        int difference = Math.abs(leftHeight - rightHeight);
        if(difference >1) return false;
     
        return isBalanced(root.left) && isBalanced(root.right);
        
    }
    
    private static int FindHeight(TreeNode root){
        if (root == null) return 0;
        int left = FindHeight(root.left);
        int right = FindHeight(root.right);
        int height = 1+ Math.max(left, right);
        return height;
    }
}
//apprach with memoisation
/*class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
    if (root == null) return true;
      int leftDepth = Depth(root.left);
      int rightDepth = Depth(root.right);
      if (Math.abs(leftDepth - rightDepth) > 1)
        return false;
      return isBalanced(root.left) && isBalanced(root.right);
    }
  
  private int Depth(TreeNode root) {
    if (root == null) return 0;
    if (map.containsKey(root)) {
        return map.get(root);
    }
    int left = Depth(root.left);
    int right = Depth(root.right);
    int height = Math.max(left, right) + 1;
    map.put(root, height);
    return height;
  }
}
*/
public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        TreeNode tree = new TreeNode(3); 
        tree.left = new TreeNode(9); 
        tree.right = new TreeNode(20);    
        tree.right.left = new TreeNode(15); 
        tree.right.right = new TreeNode(7); 
        boolean output = Solution.isBalanced(tree); 
        if (output == true) 
            System.out.println("it is balanced tree"); 
        else
            System.out.println("it is not balanced tree"); 

	}

}
