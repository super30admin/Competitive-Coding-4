// Balance binary tree

// Time Complexity : O(n) where n is the nodes in the tree
// Space Complexity : O(h) recursive stack height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// bottom up approach. Whenever we see a null node, we return 0 ( as in the height is 0 so far) and then increment the height of
// the first node on the recursive stack. For eg: if the tree looks like 1 -> 2 -> 3 -> null (containing only left subtree), then the 
// height of 3=1, 2=2, 1=3. At each parent node, calculate the height of the current node based on max of (left and right child)+1. At any point,
// if the absolute value of height of left - height right, we return -1 (indicating out of balance). 

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(helper(root) == -1) return false;
        return true;
    }
    
    private int helper(TreeNode root){
        
        //base
        if(root == null) return 0; // returning back with the height of 0 from the null node
        
        //logic
        int left = helper(root.left); 
        int right = helper(root.right);
        
        if(left == -1 || right == -1 || Math.abs(left-right) > 1){
            return -1; // indicating out of balance tree
        }
        
        return Math.max(left,right)+1; // calculating the height of the cur node
        
        
    }
}

// palindrome LL
// Time Complexity : O(n) where n is the nodes in the tree
// Space Complexity : O(h) recursive stack height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
// Iterative solution

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
  boolean result=false;

        Stack<Integer> s= new Stack<Integer>();
        ListNode temp= head;

        while(temp!=null){
            s.push(temp.val);
            temp=temp.next;
        }

        while(!s.isEmpty()){
            int element=s.pop();
            if(element==head.val){
                result=true;
                head= head.next;
            }else if( element!=head.val){
                result =false;
                return result;
            }
        }
        return result;
    }
}
