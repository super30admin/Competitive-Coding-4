// Time Complexity : O(n)
// Space Complexity : O(H)
public class BalancedTree {	
	/**Definition for binary tree node.**/
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {this.val = val;}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	boolean flag;
    public boolean isBalanced(TreeNode root) {  
        flag=true;
        helper(root, 0);  
        return flag;       
    }
    
    private int helper(TreeNode root, int h){
        //base
        if(root==null) return 0;        
        
        //logic        
        int lh = helper(root.left, h);
        int rh = helper(root.right, h);
        
        //Not balanced if height difference is more than 1
        if(Math.abs(lh-rh) >1) {
            flag=false;
        }
        
        return Math.max(lh, rh)+1;
    }
	 
    //Driver code to test above
    public static void main (String[] args) {
    	BalancedTree ob = new BalancedTree();
    	//TreeNode node= new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    	TreeNode node= new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
		    	
		System.out.println("Is Tree height balanced?: "+ob.isBalanced(node));	
		
	}
}