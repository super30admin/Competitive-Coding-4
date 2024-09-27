
class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class isPlalindrome {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        head2 = reverseList(head2);
        slow.next=null;

        ListNode h1 = head;
        ListNode h2 = head2;
        while(h2!=null){
            if(h1.val!=h2.val){
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }
    private ListNode reverseList(ListNode head){
        if(head==null||head.next==null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        while(fast!=null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        head = curr;
        return head;
    }
}
