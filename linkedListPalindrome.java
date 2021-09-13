// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
class linkedListPalindrome {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow.next != null){
            fast = reverse(slow.next);
        }
        else{
            return true;
        }
        slow.next = null;
        slow = head;
        
        while(fast != null){
            if(slow.val == fast.val){
                slow = slow.next;
                fast = fast.next;
            }
            else{
                return false;
            }
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode nxt = head.next;
        while(nxt != null){    
            curr.next = prev;
            prev = curr;
            curr = nxt;
            nxt = nxt.next;
        }
        curr.next = prev;
        return curr;
    }
}