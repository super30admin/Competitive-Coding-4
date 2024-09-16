//time complexity: O(n) where n is the number of nodes in the linked list
//space complexity: O(1)
//executed on leetcode: yes
//approach: 1.start with slow and fast pointers at head
//2.in case of odd length list, when fast.next=null, slow will be at the middle
//3. in case of even length list, when fast.next.next=null, slow will be at the middle
//4. when list is odd, we need to check reverse of the list from middle+1th node to last node is equal to the list from head to middle-1th node
//5. in case of even length linked list, we need to check if the reverse of the list from the middle+th node to last node is equal to the list from head to middle node
class Solution {
    boolean even;
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        if(head.next==null) return true;
        ListNode slow = head;
        ListNode fast = slow;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode middle = slow;
        if(fast.next==null) return check(head,middle,false);
        return check(head,middle,true);
        
        
    }
    public boolean check(ListNode head,ListNode middle,boolean even)
    {
        if(even==true)
        {
            ListNode temp = middle.next;
            ListNode prev = null;
            while(temp!=null)
            {
                ListNode next_node = temp.next;
                temp.next=prev;
                prev=temp;
                temp=next_node;
            }
            while(head!=middle.next)
            {
                if(head.val!=prev.val) return false;
                head= head.next;
                prev=prev.next;
            }
        }
        else
        {
            ListNode temp = middle.next;
            ListNode prev = null;
             while(temp!=null)
            {
                ListNode next_node = temp.next;
                temp.next=prev;
                prev=temp;
                temp=next_node;
            }
            while(head!=middle)
            {
                if(head.val!=prev.val) return false;
                head= head.next;
                prev=prev.next;
            }
        }
        return true;
    }
}