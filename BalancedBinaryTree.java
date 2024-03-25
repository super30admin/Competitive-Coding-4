class TreeNode {
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
 

 // tc = o(nlogn) n for height,log n for balance function
 // sc = o(n) recursion 
 class Solution {
    private int height(TreeNode root){
        if(root == null)return 0;
        int LH = height(root.left);
        int RH = height(root.right);
        return 1 + Math.max(LH,RH);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        int left = height(root.left);
        int right = height(root.right);
        int diff = Math.abs(right - left);
        if(diff > 1)return false;
        else return isBalanced(root.left)&&isBalanced(root.right);
    }
}