import java.util.ArrayList;

public class PalindromeLinkedList {
  
    /**
     * Time Complexity: O(N) // where N is the number of nodes in the list, since we are traversing the list once
     * Space Complexity: O(N) // where N is the number of nodes in the list, since we are storing the values in an array list
     */
    //Approach 1: traverse through the list and store values in an arraylist, compare to check for palindrome constraints
 // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        ArrayList<Integer> values = new ArrayList<>();
        while(cur != null) {
            values.add(cur.val);
            cur = cur.next;
        }

        int i=0;
        int j = values.size()-1;
        while(i <= j) {
            if(values.get(i) != values.get(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

/**
 * Time Complexity: O(N) // since we are traversing the linked list once.
 * Space Complexity: O(1) // since we are not using any extra space
 */
/*
 Approach 2 : 
    1. find mid of the linked list
    2. Reverse the 2nd half of the list
    3. Now we have 2 lists , compare the 2 lists

*/ 

class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        // find mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the second half of the list
        ListNode prev = null;
        ListNode cur = slow.next;
        ListNode next = cur.next;
        while(cur != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            if(next != null) next = next.next;
        }

        //compare the 2 lists
        ListNode head2 = prev;
        slow.next = null;
        while(head != null && head2 != null) {
            if(head.val != head2.val)   
                return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;

    }

    
}


}