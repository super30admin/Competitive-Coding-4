// Time Complexity :O(n)
// Space Complexity :1
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :at first I got a lot of null pointer exceptions,after that it was comparing one less element.


// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) 
    {//taking slow and fast pointers to keep track of the list after division 
        ListNode slow=head;
        ListNode fast=head;
        //Len to calculate the length of the list
        ListNode Len=head;
        int count=0;
        if(head==null || head.next==null)return true;
        while(Len!=null)
        {
            count+=1;
            Len=Len.next;
        }
        //length of list is calculated
        //making special case of length=2
       if(count==2)
       {
           if(head.val==head.next.val)
           {return true;}
          return false;
       }
        //placing slow to middle
        for(int i=0;i<(count/2)-1;i++)
        {
            slow=slow.next;
        
        }
        //reversing the list and pointing head of reversed list as fast
        fast=reverseList(slow.next);
        //separating the first part of the list
        slow.next=null;
        slow=head;
        //taking a flag to return the output
        boolean flag=true;
        //incrementing slow and fast and comparing both as well until slow becomes null
        while(slow!=null )
        {
            if(slow.val!=fast.val)
                //if any element is not equal flag will be returned as false
            {flag=false;}
           
            slow=slow.next;
            fast=fast.next;
             // System.out.println(slow.val);
            //System.out.println(fast.val);
        }
        return flag;
    }
    
     private ListNode reverseList(ListNode head)
    {
        ListNode temp=null;
        ListNode curr=head;
        while(curr.next!=null)
        {
            temp=curr.next;
            curr.next=temp.next;
            temp.next=head;
            head=temp;
        }
        return head;
    }
}
