// Time Complexity : o(n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Pair
{
    int height;
    boolean isBalanced;
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if(root==null)
            return true;
        
        return helper(root).isBalanced;
             
    }
    
    private Pair helper(TreeNode root)
    {
        if(root==null)
        {
            Pair p =new Pair();
            p.height=-1;
            p.isBalanced=false;
            return p;
        }
        
        
        Pair lp=helper(root.left);
        System.out.print(lp.height+" ");
        Pair rp=helper(root.right);
        System.out.print(rp.height+" ");
        Pair rootPair=new Pair();
        rootPair.height=Math.max(lp.height,rp.height)+1;
        System.out.print(rootPair.height+" ");
        System.out.println();
        int heightDiff = Math.abs(lp.height - rp.height);
        if((heightDiff>1))
        {
            rootPair.isBalanced=false;
        }
        else
        {
            rootPair.isBalanced=true;
        }
        
        return rootPair;
    }
}
