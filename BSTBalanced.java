// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : I faced some problems in the edge cases where one side was null and other was not.


// Your code here along with comments explaining your approach



//  Definition for a binary tree node.
public class BSTBalanced {
	int val;
	BSTBalanced left;
	BSTBalanced right;
	BSTBalanced(int x) { val = x; }
}

class Solution {
	public boolean isBalanced(BSTBalanced root) {

		if(root == null) return true;
		if(root.left == null && root.right == null) return true;
		if(root.left != null || root.right != null) {
			if(Math.abs(treeHeight(root.left) - treeHeight(root.right)) < 2 ){
				if(isBalanced(root.left) && isBalanced(root.right))
					return true;
			}   
		}
		return false;
	}

	//private heler function to calculate height of tree recursively
	private int treeHeight(BSTBalanced root){
		if(root == null){
			return -1;
		}
		int l = treeHeight(root.left);
		int r = treeHeight(root.right);
		int h = Math.max(l,r);
		return h+1;
	}
}