"""
TC: O(N) Iterate over N nodes
SP: O(1)

"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self, root):
        curr = root
        prev = None
        while curr:
            curr_next = curr.next
            curr.next = prev
            prev = curr
            curr = curr_next
        return prev
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        mid = slow
        reversedhalf = self.reverse(mid)
        curr = head
        while curr!=mid:
            if curr.val!=reversedhalf.val:
                return False
            curr = curr.next
            reversedhalf = reversedhalf.next
        return True




        
        