# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow=head
        fast=head.next



        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next

        tempF = slow.next
        slow.next = None
        prev = None
        while tempF:
            temp = tempF.next
            tempF.next=prev
            prev=tempF
            tempF = temp


        tempB = head
        while tempB and prev:
            if tempB.val == prev.val:
                tempB=tempB.next
                prev=prev.next
            else:
                return False



        return True
        