// Time Complexity :O(n) as we would traverse all the nodes of linked list linearly
// Space Complexity : O(1)as no auxiliary space used
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }

        //find the middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //break the link
        fast = reverse(slow.next);//list 2 start
        slow.next = null;

        //reverse the second half
        ListNode p1 = head;
        ListNode p2 = fast;

        //compare
        while(p2 != null){
            if(p1.val != p2.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode node){

        ListNode prev = null;
        while(node != null){
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}
