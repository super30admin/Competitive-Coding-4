public class PalindromeLinkedList {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public boolean isPalindrome(ListNode head) {
        /*

        TC : O(n)
        SC : O(1)

        */
        if(head==null || head.next==null) return true;

        //find the middle of the linked list
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode reversed = reverseList(slow);
        fast=reversed;
        slow=head;

        if(fast==null){
            return false;
        }
        while(slow!=null && fast!=null){

            if(slow.val!=fast.val){
                return false;
            }
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode prev = null;
        ListNode curr=head;
        ListNode fast=head.next;

        while(curr!=null && curr.next!=null){
            fast=curr.next;
            curr.next=prev;
            prev=curr;
            curr=fast;
        }
        curr.next=prev;
        return curr;
    }
}
