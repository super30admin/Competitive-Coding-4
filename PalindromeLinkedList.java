package S30.CompetitiveCoding_4;

/*
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class PalindromeLinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    ListNode frontNode = null;

    //Recursive solution
    public boolean isPalindrome(ListNode head) {

        this.frontNode = head;
        return checkPalindrome(head);


    }

    public boolean checkPalindrome(ListNode node){
        if(node == null) return true;
        if(checkPalindrome(node.next) == false) return false;

        if(frontNode.val == node.val){
            frontNode = frontNode.next;
            return true;
        }else return false;
    }
}
