# Time Complexity: O(N)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Here we reverse the 2nd half of the linkedlist and then compare the head and reversed_heads one by one
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head==None or head.next==None:
            return True
        curr = head
        rev_index = self.getMid(head)
        rev_head = self.revL(rev_index)
        while head and rev_head:
            if head.val!=rev_head.val:
                return False
            head=head.next
            rev_head=rev_head.next
        return True

    def getMid(self,start):
        slow = start
        fast = start
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow

    def revL(self,start):
        prev = None
        curr = start
        ahead = start.next
        while curr:
            curr.next = prev
            prev = curr
            curr = ahead
            if curr==None:
                break
            ahead = ahead.next
        return prev

    # First approach
#     def isPalindrome(self, head: Optional[ListNode]) -> bool:
#         if head==None or head.next==None:
#             return True
#         curr = head
#         length = 0
#         while curr:
#             curr=curr.next
#             length+=1
#         revi = head
#         count = length//2
#         while count>0:
#             revi=revi.next
#             count-=1
#         if length%2!=0:
#             revi = revi.next
#         revh = self.revL(revi)
#         mid = length//2
#         while mid>0:
#             if head.val!=revh.val:
#                 return False
#             head=head.next
#             revh=revh.next
#             mid-=1
#         return True

#     def revL(self,start):
#         prev = None
#         curr = start
#         ahead = start.next
#         while curr:
#             curr.next = prev
#             prev = curr
#             curr = ahead
#             if curr==None:
#                 break
#             ahead = ahead.next
#         return prev