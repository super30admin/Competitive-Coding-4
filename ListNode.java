
//   Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
 //T.C- O(N) ; S.C-O(1),
 //Approach- find the middle, reverse the second half and compare each value, if the value is not same then false,
 //plus point- the list is broken, restore/re-reverse the second half and then return result- good coding practice;
class Solution {
    public boolean isPalindrome(ListNode head) {

      ListNode endof_firsthalf= findmiddle(head); //find middle
      ListNode startof_second= reverse(endof_firsthalf.next); //reverse the second half

      ListNode p1= head;
      ListNode p2= startof_second;
      boolean result= true; //flag

      while(result && p2!=null){ 
        if(p1.val!= p2.val){ //compare each value
          return false;
        }
        p1= p1.next;
        p2=p2.next;
      }

      startof_second= reverse(startof_second); //restore/re-reverse the broken list
      return result;
        
    }

    public ListNode reverse(ListNode head){ //reverse function
      ListNode curr= head;
      ListNode prev= null;
      while(curr!=null){
        ListNode temp= curr.next;
        curr.next= prev;
        prev= curr;
        curr= temp;
      }
      return prev;
    }

    public ListNode findmiddle(ListNode head){ //find the middle- fast and slow pointer
      ListNode slow= head;
      ListNode fast= head;
      while(fast.next!=null && fast.next.next!=null){
        slow= slow.next;
        fast=fast.next.next;
      }
      return slow;
    }
}