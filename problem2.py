#Time complexity O(n), space O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        s=head
        f=head
 #Finding mid point       
        while f and f.next:
            s=s.next
            f=f.next.next
            
        node =None
#reversing after mid        
        while s:
            nxt= s.next
            s.next = node
            node=s
            s=nxt
#comparing values with the head values            
        while node:
            if node.val != head.val:
                return False
            node=node.next
            head=head.next
            
        return True
