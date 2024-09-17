// 234.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//time - O(n)
//space - O(n) dude to the recursive stack size in reverse() which can be made constant if done iteratively
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
        {
            return true;
        }
        
        ListNode middle = findMiddle(head);
        ListNode l2 = reverseList(middle.next);
        middle.next = null;
        ListNode l1 = head;
        return compareLists(l1, l2);
    }
    
    //time - O(n) with constant space
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode temp = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //if length of list is odd then fast = null, so middle doesn't matter in palindrome so return prev of middle else return middle (fast.next == null)
        if(fast == null)
        {
            while(temp.next != slow)
            {
                temp = temp.next;
            }
            return temp;
        }
        return slow;
    }
    
    //time - O(n) with size of recursive stack O(n) that can be reducedto constant if done iteratively
    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode current = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return current;
    }
    
    //chcecks for equaality
    //time -O(n) with constant space
    private boolean compareLists(ListNode l1, ListNode l2) {
        while(l1 != null)
        {
            if(l1.val == l2.val)
            {
                l1 = l1.next;
                l2 = l2.next;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
