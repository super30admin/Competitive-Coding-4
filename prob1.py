#Palindrome linked list

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Find the middle of the linked list, reverse the second half, and compare it with the first half.
# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        prev = None
        while slow:
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp
        while prev:
            if prev.val != head.val:
                return False
            head = head.next
            prev = prev.next
        return True

        