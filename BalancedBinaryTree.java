// Time O(n)
// Space O(n)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<TreeNode , Integer> h = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode > st = new Stack<>(); // O(n) n number of elements
        st.add(root);
        while(!st.isEmpty())
        {
            TreeNode curr= st.pop();
            if(curr.right!=null)
                st.add(curr.right);
            if(curr.left!=null)
                st.add(curr.left);
            System.out.println("Processing "+curr.val);
            int left =  h.getOrDefault(curr.left, helper(curr.left));
            int right = h.getOrDefault(curr.right,helper(curr.right));
            for(TreeNode t: h.keySet())
                System.out.println(t.val+" : "+h.get(t));
            if(Math.abs(left-right)>1)
                return false;
        
            
       }
        return true;
    }
    
  private int helper(TreeNode root)
  { 
      if(root==null)
          return 0;
      int max= Math.max(1+helper(root.left), 1+helper(root.right));
      
      h.put(root, max);
      return max;
      
      
      
  }
    
    
}