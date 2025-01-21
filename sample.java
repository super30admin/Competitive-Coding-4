// Time Complexity : 0(N)
// Space Complexity : 0(H) ; H=height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Recursive approach

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
    boolean validate=true;

    public boolean isBalanced(TreeNode root) {
        recurse(root,0);
        return validate;
    }

    private int recurse(TreeNode n,int height){
        if(n==null){
            return 0;
        }
        int leftHeight=recurse(n.left,height); //==0
        int rightHeight=recurse(n.right,height); //
        //calulate the height
        if(Math.abs(leftHeight-rightHeight)>1){
            validate=false;
            return 0;
        }
        return 1+Math.max(leftHeight,rightHeight);
    }
}

// Time Complexity : 0(N)
// Space Complexity : 0(n) ; n=no of nodes in tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode current=head;
        List<Integer> value=new ArrayList<>();
        while(current!=null){
            value.add(current.val);
            current=current.next;
        }
        int n=value.size();
        for(int i=0;i<n/2;i++){
            if(value.get(i)!=value.get(n-1-i)){
                return false;
            }
        }
        return true;
    }
}