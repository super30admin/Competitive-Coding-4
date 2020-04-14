# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#Time Complexity - O(n)
#Space Complexity - O(1)
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head is None:
            return True
        slow=head
        fast=head
        stack=[]
        while fast and fast.next:
            stack.append(slow.val)
            
            slow=slow.next
            fast=fast.next.next
        
        if fast is not None:
            slow=slow.next
        while(slow and len(stack)):
            if stack.pop()==slow.val:
                
                slow=slow.next
            
            else:
                return False
            
            
        return True