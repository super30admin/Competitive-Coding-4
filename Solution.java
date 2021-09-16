public class Solution {
       // Time Complexity : N
// Space Complexity : 1
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : no
//https://leetcode.com/problems/palindrome-linked-list/submissions/
    public boolean isPalindrome(ListNode head) {
        //edge cases
        if(head == null || head.next== null){
            return true;
        }
        if(head.next.next == null){
            if(head.val != head.next.val) return false;
            else{
                return true;
            }
        }
        
        //find the mid
        ListNode slow = head;
        ListNode fast = head.next;
        int count = 0;
        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            count++;
        }
        
        //reverse from the mid
        ListNode curr = slow;
        ListNode prev = null;
        ListNode temp = slow.next;
        while(temp!= null){
            prev= curr;
            curr=temp;
            temp=temp.next;
            curr.next=prev;
            
        }
        
        //compare the values
        while(count>=0){
            if(head.val!=curr.val)return false;
            else{
                head=head.next;
                curr=curr.next;
                count--;
            }
        }
        return true;
    }
    // Time Complexity : N
// Space Complexity : H
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : no
//https://leetcode.com/problems/balanced-binary-tree/submissions/
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int height = height(root);
        return height != -1;
    }
    private static int height(TreeNode root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        int height = Math.abs(lh-rh);
        if(height>1) return -1;
        if(lh == -1 || rh == -1) return -1;
        return  Math.max(lh,rh)+1;
        

    }
}
