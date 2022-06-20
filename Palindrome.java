class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast.next!= null && fast.next.next!=null){
           fast = fast.next.next; 
            slow = slow.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        while(slow!=null && fast!= null){
          //  System.out.println("slow value is" +slow.val);
          //  System.out.println("fast value is" +fast.val);
             if(slow.val !=fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
           
        }
        return true;

    }
     public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head;
        while(curr!= null){
            temp = temp.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
     }
     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}