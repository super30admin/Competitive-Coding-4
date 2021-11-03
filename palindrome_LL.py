# Time Complexity : O(n) 
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return True
        slow = head
        fast = head.next
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        head2 = slow.next
        slow.next = None
        curr = head2
        prev = None
        #reverse second half
        while curr is not None:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
        head2 = prev
        while head is not None and head2 is not None:
            if head.val != head2.val:
                return False
            head = head.next
            head2 = head2.next
        return True
