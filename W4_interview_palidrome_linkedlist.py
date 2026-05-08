# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = head
        fast = head

        # find middle
        while fast and fast.next is not None:
            slow = slow.next
            fast = fast.next.next


        # reverse the second half
        prev = None
        curr = slow

        while curr is not None:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp

        left = head
        right = prev

        # compare 
        while right is not None:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next
        
        return True

# Time complexity: O(n) since we visit each node. 
# Space complexity: O(1)

