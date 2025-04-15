// Time Complexity : 0(n)
// Space Complexity :0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
* It uses two pointers, slow and fast, to find the middle of the list,
* then reverses the second half starting from the midpoint.
* After that, it iterates through both halves, comparing corresponding node values.
* If all values match, the list is a palindrome; otherwise, it’s not.
* The solution runs in O(n) time and uses O(1) extra space.
*
*
*
* */


class PalindromLinkedList {


    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode reverseList=reverse(slow);
        System.out.println(reverseList.val);

        ListNode curr=head;

        while(reverseList!=null && curr!=null)
        {
            if(reverseList.val!=curr.val)
                return false;
            reverseList=reverseList.next;
            curr=curr.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

