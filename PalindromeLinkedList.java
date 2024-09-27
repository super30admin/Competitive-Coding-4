//Problem : 58 - PalindromeLinkedList
// Time Complexity : O(n), n stands for number of nodes
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Questions to be asked at the time of interview:
// Can I modify existing linkedlist, Data type of Node value.

// Your code here along with comments explaining your approach
/*
Bruteforce/If given linked list cannot be modified: Add all the elements in array list and then using two pointers check whether it is pallindrome or not
Optimised:
  1) First find middle of the linkedlist
  2) Reverse the list
  3) Compare both the parts that is one till middle and other part which is reversed.
  4) While comparing both the parts if both the node values are different return false;
*/

/*Note : For Finding middle two ways are there
         1) fast!=null && fast.next!=null : Here catch is if number of nodes are even, then its going to give right element of the middle which is second middle node
            Eg: 1->2->3->4, here middle is going to be 3
         
         2) fast.next!=null && fast.next.next!=null, Here, if number of nodes are even, then its going to give left element of the middle which is first middle node.
            Eg: 1->2->3->4, here middle is going to be 2

         For odd number of nodes, both works fine.
         At the time of interview, generate even and odd use case, and ask interviewer about which middle node should be considered    
*/

class Solution58 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public boolean isPalindrome(ListNode head) {
        
        if(head==null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        
        //1) Find Mid
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //1->2->2->1
        //  1->2
        
        //2) Reversed
        ListNode head2 = reverseList(slow.next);
        slow.next= null;//breaking the chain
        
        ListNode curr1 = head;
        ListNode curr2 = head2;
        
        while(curr1!=null && curr2!=null){
            
            if(curr1.val!=curr2.val) return false;
            
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        return true;
    }
    
    
    private ListNode reverseList(ListNode head){
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev  = curr;
            
            curr = next;
        }
        
        return prev;
    }
    
}