// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
1)traverse till the mid of the linked list.
2)separate the seond half of the linked list and reverse it.
3)traverse the first half and the second half of the linked list.If the values are not the same then return False else traverse till the end of the linked list and then if all the elements match returnn True.
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Time complexity --> o(n)
# space complexity --> o(1)
class Solution:
    def rev(self,prev:ListNode,curr:ListNode,next1:ListNode)->ListNode:
        while curr!=None:
            next1=next1.next
            curr.next=prev
            prev=curr
            curr=next1
        return prev  
    
    def isPalindrome(self, head: ListNode) -> bool:
        if head==None or head.next==None:
            return True
        slow=head
        fast=head
        while fast.next!=None and fast.next.next!=None:
            slow=slow.next
            fast=fast.next.next
        prev=None
        curr=slow.next
        slow.next=None
        next1=curr
        slow=head
        f=self.rev(prev,curr,next1)
        # print(f.val,slow.val)
        while f!=None:
            # print(slow.val,f.val)
            if slow.val!=f.val:
                return False
            slow=slow.next
            f=f.next
        return True
            
        