/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// TC : O(N) -  N nodes of list
// SC: O(1) 
// Did it run successfully on Leetcode? : Yes
class Solution {
    //reverse second half in place 
    public boolean isPalindrome(ListNode head) {
        if ( head == null)
            return true;
        ListNode endOfFirstHalf = firstHalfEndsHere(head);
        ListNode startOfSecondHalf = reverse(endOfFirstHalf.next);
        
        ListNode p1 = head;
        ListNode p2 = startOfSecondHalf;
        while (p1 != null && p2!=null)
        {
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
    private ListNode firstHalfEndsHere(ListNode node)
    {
        if ( node == null)
            return null;
        ListNode slow = node;
        ListNode fast = node;
        while ( fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode node)
    {
        if ( node == null)
            return null;
        ListNode cur = node;
        ListNode prev = null;
        while ( cur != null)
        {
            ListNode temp = cur.next;
            cur.next = prev;
            prev= cur;
            cur = temp;
        }
        return prev;
    }
}
// TC : O(N) -  N nodes of list
// SC: O(N) - N nodes of list
// Did it run successfully on Leetcode? : Yes
// public boolean isPalindrome(ListNode head) {
    //if ( head == null) return true;
      // List<Integer> list = new ArrayList<Integer>();
      //     ListNode cur = head;
      //   while ( cur != null)
      //   {
      //       list.add(cur.val);
      //       cur = cur.next;
      //   } 
      //   int i = 0;
      //   int j = list.size()-1;
      //   while ( i < j)
      //   {
      //       if (!list.get(i).equals(list.get(j)))
      //           return false;
      //           i++;
      //           j--;
      //   }
      //   return true;
//}
