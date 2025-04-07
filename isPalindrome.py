# This solution checks whether a singly linked list is a palindrome using the fast and slow pointer technique.
# It first finds the middle of the list, reverses the second half, and then compares both halves for equality.
# This approach avoids using extra space by performing the check in-place.

# Time Complexity: O(n), where n is the number of nodes in the list. Each node is visited at most twice.
# Space Complexity: O(1), since the algorithm uses constant extra space.

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow = fast = head

        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        prev = None
        cur = slow.next
        while cur:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        
        head2 = prev
        head1 = head
        while head2:
            if head2.val != head1.val:
                return False
            head1 = head1.next
            head2 = head2.next
        
        return True
