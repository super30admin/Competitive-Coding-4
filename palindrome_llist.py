# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


class ListNode:
    def __init__(self, val, next) -> None:
        self.val = val
        self.next = next

class solution:
    def isPalindrome(self, head):

        fast = slow = head

        # to find the mid point
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next

        # reverse the second half
        prev = None
        while slow:
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp

        # check for palindrome
        left, right = head, prev

        while right:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next

        return True



