
import java.util.*;

class PalindromLinkedList {

  public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

  // Time Complexity : O(N)
  // Space Complexity : O(1)
  // Did this code successfully run on Leetcode : YES
  // Any problem you faced while coding this : NO
  // Approach : Find middle, Reverse from there, then check both lists

  public boolean isPalindrome(ListNode head) {
      if(head == null) return false;
      // 1.Find middle
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode slow = dummy;
    ListNode fast = dummy;

    // find middle using two pointers
    while(fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }

    //middle is at slow.next
    ListNode reversePoint = slow.next;
    ListNode prev = null;
    ListNode curr = reversePoint;
    // reverse a LinkedList
    while(curr != null){
      ListNode temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    slow.next = null;

    slow = dummy.next;
    fast = prev;

    // check for palindrom in both lists
    while(slow != null && fast != null){
      if(slow.val != fast.val){
        return false;
      }
      slow = slow.next;
      fast = fast.next;
    }

    // reverse back to make it original list
    curr = prev;
    prev = null;

    while(curr != null){
      ListNode temp = prev.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    reversePoint.next = prev;
    printList(head);


    return true;

  }

  // Time Complexity : O(N)
  // Space Complexity : O(N)
  // Did this code successfully run on Leetcode : YES
  // Any problem you faced while coding this : NO
  // Approach : Iterate over LL and Store items in ArrayList
  // then check array list for palindrom using two pointers

  public boolean isPalindromeExtraSpace(ListNode head) {
        if(head == null) return true;

        List<Integer> records = new ArrayList<>();

        ListNode curr = head;

        while(curr != null){
            records.add(curr.val);
            curr = curr.next;
        }
        int low = 0;
        int high = records.size() - 1;

        while(low < high){

            if(records.get(low).intValue() == records.get(high).intValue()){
                low++;
                high--;
            }else{
                return false;
            }
        }

        return true;
    }

    private static void printList(ListNode node){
      ListNode temp = node;
      while(temp != null){
        System.out.print(temp.val + "->");
        temp = temp.next;
      }

      System.out.print("\n");
    }
}
