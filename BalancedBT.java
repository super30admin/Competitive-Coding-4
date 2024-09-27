// Time Complexity : O(NlogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.LinkedList;
import java.util.Queue;

public class BalancedBT {
	 public boolean isBalanced(TreeNode root) {
	        if(root==null) return true;
	        Queue<TreeNode> queue=new LinkedList<>();
	        queue.add(root);
	        while(!queue.isEmpty()){
	           TreeNode curr=queue.poll();
	          if(Math.abs(length(curr.left,0)-length(curr.right,0))>1)return false;
	           if(curr.left!=null) queue.add(curr.left);
	           if(curr.right!=null) queue.add(curr.right);
	        }
	                   
	        return true;
	    }
	    
	    public int length(TreeNode node,int len){
	        if(node==null){
	            return len;
	        }
	        
	       int left= length(node.left, len+1);
	       int right= length(node.right,len+1);
	        
	        return Math.max(left,right);
	    }
	    
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
}
