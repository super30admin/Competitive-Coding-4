"""
I added a dummy node at the start to handle edge cases, then found the linked list's midpoint. After reversing the second half of the list, I used two pointers to compare elements from both ends to check for a palindrome. 
Time Complexity: O(n)
Space Complexity: O(1)
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if not head:
            return False
        dummy = ListNode(-1)
        dummy.next = head
        slow = dummy
        fast = dummy
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
  
        prev = None
        curr = slow.next
        while curr:
            tempNode = curr.next
            curr.next = prev
            prev = curr
            curr = tempNode
        
        first = dummy.next
        second = prev

        while second:
            if first.val != second.val:
                return False
            first = first.next
            second = second.next
        return True    