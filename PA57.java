//Leetcode 234. Palindrome Linked List
//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        ListNode slow= head;
        ListNode fast= head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        
        
        ListNode nHead= reverse(slow);
        while(nHead!=null && head!=null){
            if(nHead.val!=head.val){
                return false;
            }
            head= head.next;
            nHead= nHead.next;
        }
        return true;
        
        
        
    }
    private ListNode reverse(ListNode ref){
        if(ref==null){
            return null;
        }
        ListNode prev= null;
        ListNode curr= ref;
        ListNode fast= ref.next;
        while(fast!=null){
            curr.next= prev;
            prev= curr;
            curr=fast;
            fast= fast.next;
        }
        curr.next =prev;
        return curr;
    }
}