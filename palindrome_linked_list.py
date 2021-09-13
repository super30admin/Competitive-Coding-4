# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(1)


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow, fast = head, head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        print((slow.val))
        # reverse LL from mid to end
        curr = self.reverse(slow)
        # check for palindrome
        # head -> slow
        # curr -> slow
        while curr:
            if head.val != curr.val:
                return False
            head = head.next
            curr = curr.next
        return True
    
    def reverse(self, head):
        curr = head
        prev = None
        _next = None
        while curr:
            _next = curr.next
            curr.next = prev
            prev = curr
            curr = _next
        return prev