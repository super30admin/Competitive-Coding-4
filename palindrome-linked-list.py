'''
Time Complexity: O(n)
Space Complexity: O(1) for the iterative approach, O(n) for the recursive approach due to the call stack. 

Approach: 
1. Find the middle node of the linked list.
2. Reverse the second half of the linked list.
3. Compare the first half with the reversed second half.    
4. Return true if they are the same, otherwise return false.
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:

        def reverse(node):
            prev = None
            curr = node
            while curr:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp

            return prev

        # find the middle

        slow = fast = head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next

        # middle would be slow

        reversed = reverse(slow)
        # breaking the first part with the second part
        slow.next = None
        while head and reversed:
            if head.val != reversed.val:
                return False
            head = head.next
            reversed = reversed.next

        return True
