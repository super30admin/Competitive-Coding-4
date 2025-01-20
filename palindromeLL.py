# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # Find the mid of the LL
        s, f = head, head
        while f and f.next:
            s = s.next
            f = f.next.next
        # Reverse the 2nd half
        c, p = s, None
        while c:
            t = c.next
            c.next = p
            p = c
            c = t
        # Check if palindrome
        l, r = head, p
        while r:
            if l.val != r.val:
                return False
            l = l.next
            r = r.next
        return True
    # T: O(n), S: O(1)