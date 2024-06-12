// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO


public class Problem2 {

     if(head == null || head.next == null){
        return true;
    }
    ListNode slow = head;
    ListNode fast = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }

    // reverse the second part of linked list
    ListNode curr = slow.next;
    ListNode prev = null;
        while(curr != null){
        ListNode temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
    }

    fast = prev;
    slow = head;
        while(slow != null && fast != null){
        if (slow.val != fast.val){
            return false;
        }
        slow = slow.next;
        fast = fast.next;
    }

        return true;
}

