# S30 Mock Problem #1 Palindrome Linked List
#LeetCode #234 https://leetcode.com/problems/palindrome-linked-list/description/

# Author : Akaash Trivedi
# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# Find the middle
# reverse the 2nd half
# Check for each value from head and reverse head

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        dummy = ListNode(0)
        dummy.next = head
        slow = dummy
        fast = dummy

        # find middle
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        # slow is at middle
        # reverse the 2nd half
        prev = None
        curr = slow.next
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        # break the two linked list
        slow.next = None
        
        # to check palindrome in reversed and start-mid
        first = head
        second = prev
        while second:
            if first.val == second.val:
                first = first.next
                second = second.next
            else:
                return False
        return True