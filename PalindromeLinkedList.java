// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : where to chop the linkedlist in half, setting node.next to null

// Your code here along with comments explaining your approach
// use slow, fast pointers to find mid of the linkedlist
// reverse the 2nd half of the linkedlist
// compare both halves element by element if vals are equal else return false, terminate if either pointers reaches end of list

class Solution {
    public boolean isPalindrome(ListNode head) {
        //base case
        if(head==null || head.next==null) return true;
        
        ListNode prev = null; 
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        ListNode head2 = reverse(slow);
        ListNode ptr1 = head;
        ListNode ptr2 = head2;
        
        while(ptr1!=null && ptr2!=null){
            if(ptr1.val!=ptr2.val){
                return false;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode node){
        if(node==null || node.next==null) return node;
        
        //node.next = null;
        ListNode temp;
        ListNode p1 = node, p2 = node.next;
        node.next = null;
        while(p2!=null){
            temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        
        return p1;
    }
    
}