// TC: O(N) since we are traversing the entire tree and visiting each node
// SC: O(H) where H is height of tree

// We are traversing through the each subtree and checking if the height difference is not greater than 1. So, we will need to calculate of height of tree at each step.
// Once we have the height, we check at each level of the tree where the tree is balanced, if it is not balanced, we return false. If it is balanced, we return true;

public class BalancedBST {

	public boolean CheckBalanced(TreeNode root) {
		
		if(root==null)
			return true;
		int left = height(root.left);
		int right = height(root.right);
		if(Math.abs(left-right)>1)
			return false;
		return CheckBalanced(root.left) && CheckBalanced(root.right);
	}
	
	public int height(TreeNode root) {
		if(root==null)
			return 0;
		return 1+Math.max(height(root.left), height(root.right));
	}
	
	public static void main(String[] args) {
		
		BalancedBST cb = new BalancedBST();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(cb.CheckBalanced(root));
	}
	
}
