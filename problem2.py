# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# https://leetcode.com/problems/palindrome-linked-list/submissions/
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head==None or head.next==None:
            return True
        #Total number of elements
        length=0
        cur=head
        while(cur!=None):
            length+=1
            cur=cur.next
        prev=None
        l1=1
        slow=head
        fast=head
        
        #Mid point find
        while(fast.next!=None and fast.next.next!=None):
            
            l1+=1
            prev=slow
            slow=slow.next
            fast=fast.next.next
        head2=slow.next
        slow.next=None
        
        if l1%2==1 and prev!=None and length%2!=0:
            prev.next=None
        #Reverse
        
        cur=head2
        fast=head2.next
        prev=None
        while(fast!=None):
            cur.next=prev
            prev=cur
            cur=fast
            fast=fast.next
        cur.next=prev
        head2=cur
        #print
        cur=head
        cur2=head2
       
        while(cur!=None and cur2!=None):
            if cur.val!=cur2.val:
                return False
            cur=cur.next
            cur2=cur2.next
        
        return True
        #Time O(n)
        #Space O(1)
        
            
      
