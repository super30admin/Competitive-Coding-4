# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Space Complexity - o(1)
# Time Complexity - o(n)
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        slow = head
        fast = head
        
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        mid = slow

        prev = None
        curr = mid


        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt

        slow = head

        while prev:

            if slow.val==prev.val:
                slow = slow.next
                prev = prev.next

            else:
                return False

        return True


        
