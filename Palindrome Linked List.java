//Time Complexity :O(n)
//Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class Solution {
   public boolean isPalindrome(ListNode head) {
       //declare two pointers to find the mid
       ListNode fast, slow;
       fast = head.next;
       slow = head;
       //move the fast pointer by 2 counts
       while(fast!=null && fast.next!=null){
           slow = slow.next;
           fast = fast.next.next;
       }
       //sepearte the list by mid
       ListNode head1 = slow.next;
       slow.next = null;
       //reverse the second half of the list
       ListNode cur = head1, next,prev = null;
       while(cur!=null){
           next = cur.next;
           cur.next = prev;
           prev = cur;
           cur = next;
       }
       //point the head1 at the begining of second list
       head1 = prev;
       //compare the two list values
       while(head!=null && head1!=null){
           if(head.val != head1.val){
               return false;
           }
           head = head.next;
           head1 = head1.next;
       }
        return true;
    }
}