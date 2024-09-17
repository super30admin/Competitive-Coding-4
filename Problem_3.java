// Time Complexity :O(n)
// Space Complexity :O(height)//the height of the stack
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//traversed the binry tree in inorder way and then kept increasing the counter till the times the value of k is matched.

//below is the recursive way.
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
    private int counter;
    private int result;
    public int kthSmallest(TreeNode root, int k) {
        counter=0;
        result=0;
        inOrderTrvaersl(root,k);
        return result;
        
    }
    
    private void inOrderTrvaersl(TreeNode root,int k){//  5,5 -> 3,5, 2,5 ,1,5
                                     //1,5 ,1  ->2,5 ,2 ->3,5 3 -> 4,5 ->4, -->5,5,5  -> 6,5 6,-->5,5 ,6
        if(root==null){
            return;
        }
        inOrderTrvaersl(root.left,k);
        counter=counter+1;
        if(counter==k){
            result=root.val;
        }
        inOrderTrvaersl(root.right,k);
    }
}

// Time Complexity :O(n)
// Space Complexity :O(height)//the height of the stack
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//traversed the binry tree in inorder way and then kept increasing the counter till the times the value of k is matched.

//below is the iterative way.
//Time Complexity : O(n)
//Space Complexity :O(n)
class Solution {
    private int counter;
    private int result;
    public int kthSmallest(TreeNode root, int k) {
        counter=0;
        result=0;
        inOrderTrvaersl(root,k);
        return result;
        
    }
    //
    private void inOrderTrvaersl(TreeNode root,int k){
        if(root==null){
            return;
        }
        Stack<TreeNode> st=new Stack<TreeNode>();
        st.push(root);
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            root=st.pop();
            counter=counter+1;
            if(counter==k){
                result=root.val;
                return;
            }
           // System.out.println(root.val);
            root=root.right;
        }
    }
}
