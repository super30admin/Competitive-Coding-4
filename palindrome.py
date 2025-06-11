# Definition for singly-linked list.
#Time Complexity: O(n)
#Space Complexity: O(1) 
# Did this problem run in Leetcode: Yes
# Any problem you faced while coding this: No
# Your code here along with comments explaining your approach
# I will take two pointers one will be traversing twice as fast as the small pointer. The idea here is to get the mid.
# By the time fast is at the end, small is at middle, reverse from node
# And then compare first half and reversed half values one by one in a loop
# If equal return True

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return True
        
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        def reverse(node):
            prev = None
            while node:
                next_node = node.next
                node.next = prev
                prev = node
                node = next_node
            return prev
        second_half = reverse(slow)

        first_half = head
        while second_half:
            if first_half.val != second_half.val:
                return False
            first_half = first_half.next
            second_half = second_half.next
        return True