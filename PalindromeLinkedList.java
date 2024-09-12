// n -> number of nodes in LinkedList 
// Time Complexity: O(n);
//Space Complexity: O(1);


class Solution {
    public boolean isPalindrome(ListNode head) {
        //sanity check
        if(head == null){
            return true;
        }

        //slow and fast pointers to find mid point
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse 2nd half of linked list
        ListNode head2 = reverse(slow);

        //check if both have same values
        while(head != null && head2 != null){
            //corresponding node values are not equal return false as given LinkedList is not a palindrome
            if(head.val != head2.val){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }

        return true;

    }

    //function to reverse a LinkedList
    private ListNode reverse(ListNode root){
        //edge case
        if(root == null){
            return root;
        }

        ListNode prev = null;

        while(root != null){
            ListNode temp = root.next;
            root.next = prev;
            prev = root;
            root = temp;
        }

        return prev;
    }
}
