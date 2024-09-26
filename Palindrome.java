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
class Solution {
    public boolean isPalindrome(ListNode head) {
        boolean flag = true;
        ListNode slow = head, fast = head;
        if(head==null)
            return true;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null)
            slow = slow.next;
        
        ListNode r=new ListNode();
        r = reverse(slow);

        while(r!=null){
            if(head.val != r.val){
                flag = false;
                break;
            }
            head = head.next;
            r = r.next;
        }
        return flag;
    }
    
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

//Time complexity - O(n) n is the number of length of palindrome string/number of elements in Linked lst
//Space complexity - O(1) no extra space needed
