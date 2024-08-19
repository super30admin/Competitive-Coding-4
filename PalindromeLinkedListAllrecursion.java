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
// Time complexity = O(n)
// space complexity = O(1).
class PalindromeLinkedListAllrecursion {
    public boolean isPalindrome(ListNode head) {
        // steps to follow.
        // get the middle . break the list to list1 and list2
        // reverse the list 2
        // iterate through list 1 and list 2
        ListNode slow = getMiddle(head,head);
        
        //System.out.println("middle is " + getMiddle(head,head).val);
        // slow is the middle
        // get the length;
        int length = getLength(head);
        // but if it is odd, do I need to compare the addl node. I don't.
        // list is odd.
        if(length%2 !=0) {// odd
            slow = slow.next;
        }
        // reverse the list from slow to null (the end of the list)
        // using recursion instead of iteration.
        ListNode dummy = reverseList(slow);
        
        // reverse done of list2.
        // now comparison of list1 and list2
        while(dummy!=null && head!= null  ) {
            if(head.val != dummy.val ) {
                return false;
            }
            head = head.next;
            dummy = dummy.next;
        }
        return true;
    }
    
    private ListNode getMiddle(ListNode slow, ListNode fast) {
        if(fast==null || fast.next==null) {
            return slow;
        }
        return getMiddle(slow.next, fast.next.next);
    }
    
    private int getLength(ListNode head) {
        if(head== null) {
            return 0;
        }
        return 1+ getLength(head.next);
    }
    
    private ListNode reverseList(ListNode slow) {
        if(slow==null || slow.next== null) {
            // re= slow. saying that it this is global and re just comes and grabs the slow here.
            return slow;
        }
        ListNode re = reverseList(slow.next);// 5,5,5,5,5,5 <- always length-1 times.
        // this is stack.pop().
        slow.next.next= slow;
        slow.next = null;       
        return re;
        
        
    }

    
}