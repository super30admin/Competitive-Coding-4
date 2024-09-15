#Time: O(n)
#space: O(1)


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if(head==None or head.next==None):
            return True
        
        fast=head
        slow=head
        
        while(fast.next!=None and fast.next.next!=None):
            fast=fast.next.next
            slow=slow.next
        
        prev=None
        curr=slow.next
        slow=head
            
        while(curr.next!=None):
            temp=curr.next
            curr.next=prev
            prev=curr
            curr=temp
        curr.next=prev
            
        
        first=head
        second=curr
        
        while(second!=None and first!=None):
            print(first.val,second.val)
            if(first.val!=second.val):
                return False
            first=first.next
            second=second.next
            
        return True
        
        