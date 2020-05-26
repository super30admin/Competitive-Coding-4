//Time Complexity : O(n)
//Space Complexity : O(1)
//Runs successfully on leetcode
//No problem

//First we'll find the middle of the linekd list
//After that we'll reverse the second part of the linked list
//Now start from the head of the both the original and reversed linked list
//If the elements are not the same we will return false;



public class Competitive_Coding_4_Problem_1_palindrome {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        if(head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!= null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow.next);


        slow = head;
        fast = rev;

        while(slow!=null && fast!=null)
        {
            if(slow.val!=fast.val)
            {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;


    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null)
        {
            slow.next = prev;
            prev = slow;
            slow = fast;
            fast = fast.next;
        }
        slow.next = prev;
        return slow;
    }
}
