// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


/*Approach :
1. Find the midpoint of the list using slow and fast pointers, where fast pointers moves at 2x speed of slow. when fast reaches the end of list, slow would be at the mid of list
2. Reverse the second half of the list
3. Compare the values of first half of the list and the reversed second half
4. if all the values don't match, the list is not palindromic
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
}
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode head2=reverse(slow);

        ListNode l1=head, l2=head2;

        while(l2!=null){

            if(l1.val!=l2.val)
                return false;
            l1=l1.next;
            l2=l2.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head2){

        ListNode prev=null;
        ListNode curr=head2;

        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}

