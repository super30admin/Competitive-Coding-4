
/*
Time complexity  - O(N)
Space complexity  - O(N)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Approach -
//Find mid
//reversing the another half
//comaparing both list node by node
*/

public class LinkedListPalindrome_LC_234 {

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {  //finding mid -
            //mistake 1  - while(fast != null && fast.next != null)
            slow = slow.next; // 1 2 null
            fast = fast.next.next;
        }
        ListNode reversed = reverseList(slow.next);
        slow.next = null; //fist half
        return compareList(head, reversed);
    }

    ListNode prev = null;
    private ListNode reverseList(ListNode node) {  //reverse LinkedList
        while(node!= null){
            ListNode tmp  = node.next; //2-> 1
            node.next = prev;
            prev = node;
            node = tmp;
            //node = node.next; //mistake 2
        }
        return prev;
    }
    //compare list
    private boolean compareList(ListNode list1, ListNode list2){

        while(list1 != null && list2 != null){ // 1 2 3 2 1
            if(list1.val == list2.val) {
                list1 = list1.next;
                list2 = list2.next;
            } else {
                return false;
            }
        }
        return true;
    }


}


   class ListNode {
     int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

