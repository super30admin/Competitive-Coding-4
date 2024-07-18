// Time Complexity : O(n)
// Space Complexity : O(1)
public class PalindromeLL {
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
        }

       ListNode rev = reverse(slow);
        fast =head;
       while(fast!=null && rev !=null){
        if(fast.val != rev.val){
            return false;
        }
        fast = fast.next;
        rev = rev.next;
       }
       return true;
    }

    public ListNode reverse(ListNode root){
        ListNode prev = null;
        ListNode curr = root;
        ListNode fast = root.next;

        while(fast!=null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }

        curr.next = prev;
        return curr;
    }
}
