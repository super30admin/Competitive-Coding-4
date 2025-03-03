// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
public class ListNode {

      int val;
    
      ListNode next;
    
     ListNode(int x) { val = x; }
    
     }
class Solution {

    public boolean isPalindrome(ListNode head) {
 
        if(head==null) return true;
 
        ListNode slow= head;
 
        ListNode fast=head.next;
 
        while(fast!=null && fast.next!=null)
 
        {
 
            fast=fast.next.next;
 
            slow=slow.next;
 
        }
 
        ListNode head2=slow.next;
 
        slow.next=null;
 
        ListNode prev=null;
 
        ListNode cur= head2;
 
        ListNode next;
 
        while(cur!=null)
 
        {
 
            next=cur.next;
 
            cur.next=prev;
 
            prev=cur;
 
            cur=next;
 
        }
 
        head2=prev;
 
        while(head!=null && head2!=null)
 
        {
 
            if(head.val != head2.val) return false;
 
            else
 
            {
 
                head=head.next;
 
                head2= head2.next;
 
            }
 
        }
 
        return true;
 
    }
 
 }


 // Time Complexity :O(nlogn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

 class Solution {

    public boolean isBalanced(TreeNode root) {
 
        if(root==null) return true;
 
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left)-height(root.right))<=1;
 
    }
 
    private int height(TreeNode root)
 
    {
 
        if(root==null) return 0;
 
        else
 
            return Math.max(height(root.left),height(root.right))+1;
 
    }
 
 }