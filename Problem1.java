//234. Palindrome Linked List
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode rev = reverseList(head);
        while(head != null){
            // System.out.println(head.val + " " + rev.val);
            if(head.val != rev.val){
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode curr = head.next;
        ListNode prev = head;
        prev.next = null;
        while(curr != null){
            ListNode temp = curr.next; 
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
