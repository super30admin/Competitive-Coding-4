Palindrome Linked List
Given the head of a singly linked list, return true if it is a palindrome.
        Example 1 :
        Input: head = [1,2,2,1]
        Output: true

        Approach2 -------------------------------------------------------------------

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Reverse second half in -place and take 2 pointers one for first half and another one from reversed part of second half and keep comparing values.
If all match then its palindrome
 */
 */
        //Reverse second half in place

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        //Reverse second half and compare values
        if(head==null || head.next ==null )return true;


        ListNode firstHalf = endOfFirstHalf(head);
        ListNode secondHalf = reverse(firstHalf.next);
        //check for palindrome using 2 pointers
        ListNode p1= head, p2=secondHalf;
        while(p2!=null){
            if(p1.val!=p2.val) return false;
            p1 = p1.next;
            p2=p2.next;
        }
        return true;
    }

    private ListNode endOfFirstHalf(ListNode head){
        ListNode fast = head, slow = head;
        while(fast.next!=null && fast.next.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        ListNode prev=null, curr=head, next = curr.next;
        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;

    }
}



   Approach 1-----------------------------------------------------------------------------


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
Store all values in a list and use two pointer to check if start and end of the list values are same until middle of the list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while(curr!=null){
            list.add(curr.val);
            curr= curr.next;
        }

        int start =0, end = list.size()-1;
        while(start<end){
            if(!list.get(start).equals(list.get(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}