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
  //TC O(n) SC: O(1)
    int count=0;
    int len=0;
    
    /*
    1.find mid of the list  using slow and fast pointer
    2.find reverse of the second half of the list
    3.compare values of reversed and first half of list
    */
    public boolean isPalindrome(ListNode head) {
        ListNode mid=midOfList(head);
        ListNode rev=null;
        if(len%2==0)rev=reverse(mid);
        else rev=reverse(mid.next);
        ListNode current=head;
        Boolean flag=true;
        
        //comparing values 
        while(rev!=null && current!=null){
            if(rev.val!=current.val){
                return false;
            }
            rev=rev.next;
            current=current.next;        
        }
        return flag;
        
    }
    
     
    
    private ListNode  midOfList(ListNode node) { 
        ListNode slow=node;
        ListNode fast=node;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            count++;
        }
        return slow;
    }
    
    
    private ListNode reverse(ListNode node){
        if(node.next==null)return node;
        ListNode prev=null;
        ListNode curr=node;
        ListNode temp=null;
        
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;   
        }
        node=prev;
         return  node;
        
    }
    
}
