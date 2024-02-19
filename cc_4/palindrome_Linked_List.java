package cc_4;

public class palindrome_Linked_List {
    //TC: O(n)
    //SC: O(1)
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        int result = compare(slow, head);
        if(result==-1) return false;
        return true;
    }
    private int compare(ListNode slow, ListNode fast){
        ListNode reversedLL = reverseLL(slow);
        slow=fast;
        while(reversedLL!=null && slow!=null){
            if(slow.val!=reversedLL.val){
                return -1;
            }
            slow = slow.next;
            reversedLL = reversedLL.next;
        }
        return 1;
    }
    private ListNode reverseLL(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null)
        {
            ListNode nextnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextnode;
        }
        return prev;
    }
}
