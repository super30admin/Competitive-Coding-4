 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
// tc = o(n)
// sc = o(1)
//reverse from middle is the approach 
class Solution {
    private ListNode reverse(ListNode slow){
        ListNode prev = null;
        ListNode current = slow;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){ //this condition is most imp

            slow  = slow.next;
            fast = fast.next.next;
        }

        ListNode end = reverse(slow.next);
        slow.next = null;

        while(end != null){
            if(head.val != end.val){
                return false;
            }
            head = head.next;
            end = end.next;
        }


        
        return true;
    }
}