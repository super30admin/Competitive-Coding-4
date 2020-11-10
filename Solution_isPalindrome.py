"""
Time complexity O(N)
Space Complexity O(1)

-get the middle lement 
-reverse second half
-compare first half LL and second half LL values

"""


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution_isPalindrome:
    def isPalindrome(self, head: ListNode) -> bool:
        if head is None:
            return True
        
        slow=fast=head
        while fast.next and fast.next.next:
            slow=slow.next
            fast=fast.next.next
        
        head2=slow.next
        prev=None
        curr=head2
        Next=None
        while curr:
            Next=curr.next
            curr.next=prev
            prev=curr
            curr=Next
        head2=prev
        
        while head and head2:
            if(head.val!=head2.val):
                return False
            else:
                head=head.next
                head2=head2.next
        
        return True
        