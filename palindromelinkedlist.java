public class palindromelinkedlist {

    //Idea is to calculate middle node, reverse second half and then compare 
    //first half with second half element by element

    //Time Complexity: O(n)
    //Space Complexity: O(1)
        public boolean isPalindrome(ListNode head) {
        //Find the middle node
        ListNode fast = head, slow = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse second half

        ListNode prev = null;
        ListNode curr = slow.next;
        ListNode temp = null;

        while(curr!=null)
        {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //compare first half and second half
        slow = head;

        while(prev!=null)
        {
            if(prev.val == slow.val){
                prev = prev.next;
                slow = slow.next;
            }
            else
            {
                return false;
            }
        }
        return true;

    }
}
