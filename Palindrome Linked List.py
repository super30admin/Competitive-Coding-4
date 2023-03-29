# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        # Brute force approach

        # Time Complexity: O(n)
        # Sace Complexity: O(1)

        # ans = []
        # p1 = head
        # while p1:
        #     ans.append(p1.val)
        #     p1 = p1.next
        # return True if ans==ans[::-1] else False

        # Optimised Approach
        # Time: O(n)
        # Space: O(1)
        # Find Mid-point
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Reverse Linked List
        prev = None
        curr = slow

        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        p1 = head
        p2 = prev
        print(p1)
        print(p2)
        while p2:
            if p1.val != p2.val:
                return False
            p1 = p1.next
            p2 = p2.next
        return True



