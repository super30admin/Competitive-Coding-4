// TIme Complexity: O(nlogn)
// Space Complexity: O(n)
class Solution {
    private int findH(TreeNode root){
        if(root==null) return 0;
        int h=1;
        int left=findH(root.left);
        int right = findH(root.right);
        int max = Math.max(left,right);
        return h+max;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left=findH(root.left); // O(n)
            int right=findH(root.right); //O(n)
        if(Math.abs(left-right)>1) return false;
        return isBalanced(root.right) && isBalanced(root.left); //O(nlogn)
    }
    
}
