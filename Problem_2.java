// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Fist of all I found out the middle of the elment then reversed it from the middle of the element.
//Then compared the elements to check if it is a palidrome or not.

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
        if(head==null) return true;
        ListNode middle=findMiddle(head);
        //printLinkedList(head);
        ListNode second=middle.next;
        middle.next=null;
        //printLinkedList(head);
        second=reverseLinkeList(second);
        //printLinkedList(second);
        while(second!=null){
            if(head.val!=second.val){
                return false;
            }
            head=head.next;
            second=second.next;
        }
        return true;
    }
    
    public ListNode findMiddle(ListNode node){
        if(node==null){
            return node;
        }
        ListNode slow=node;
        ListNode fast=node;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverseLinkeList(ListNode node){
        if(node==null){
            return node;
        }
        ListNode prev=null;
        ListNode curr=node;
        ListNode fast=node.next;
        while(fast!=null){
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
    public void printLinkedList(ListNode node){
        if(node==null){
            return;
        }
        ListNode temp=node;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println();
        
    }
}