package binaryTrees;
/**
 * For every node, we are going through all the child nodes
 * Time:O(n^2)
 * Space: O(1)
 * Leetcode accepted: yes
 * Problems faced: No
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(isBalanced(root));
	}
	
	public static boolean isBalanced(TreeNode root) {
		if(root == null) return true;
        if(Math.abs(findHeight(root.left)-findHeight(root.right)) > 1) {
        		return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
	
	public static int findHeight(TreeNode root) {
		if(root == null) return 0;
		return 1+Math.max(findHeight(root.left), findHeight(root.right));
	}
}
