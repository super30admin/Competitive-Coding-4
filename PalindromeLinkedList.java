//The idea here is to first reverse the 2nd half of the list and then compare each element in the first linkedlist and the reversed 2nd linkedlist.
//Time Complexity: O(n)
//Space complexity: O(1)
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode cur = slow.next;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        ListNode p1 = head;
        ListNode p2 = prev;
        while(p2!=null){
            if(p1.val == p2.val){
                p1 = p1.next;
                p2 = p2.next;
            } else{
                return false;
            }
        }
        return true;
    }
}
