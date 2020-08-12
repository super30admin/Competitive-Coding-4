// Time Complexity : O(n)
//      n: number of elements in linked list
// Space Complexity : O(1)
//     As we only require references
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// 1. Find the middle of linked list.
// 2. Reverse second half of linked list.
// 3. Compare 1st half and reversed-2nd half.
class Problem1 {
    // definition of ListNode
    public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /** find Linked List is Palindrome */
    public boolean isPalindrome(ListNode head) {
    
        // edge case
        if(head==null || head.next==null)
            return true;
        // two pointers
        ListNode slow = head;
        ListNode fast = head.next;

        // find the middle slow -> 1x, fast -> 2x
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=  fast.next.next;
        }

        // reverse of second half of link 
        ListNode head1 = reverse(slow.next);

        // comapare both linked list
        slow = head;
        while(head1!=null){
            // value is not same
            if(slow.val != head1.val)
                return false;
            head1= head1.next;
            slow = slow.next;
        }
        // correct
        return true; 
    }

    /** reverse helper function */
    private ListNode reverse(ListNode head){
        
        // references for swap
        ListNode previous = null;
        ListNode current =  head;
        ListNode adjacent = head.next;
        
        while(adjacent!= null){
            
            // link current to previous
            current.next = previous;
            // make previous current
            previous = current;
            
            //make current adjacent
            current = adjacent;

            // next node
            adjacent = adjacent.next;
        }
        
        // for last node
        current.next = previous;
        // new head
        return current;
    }
}