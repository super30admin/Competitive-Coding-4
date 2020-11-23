"""
Time Complexity : O(n)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
first we divide our list into 2 parts, then we reverse the second haf and then we compare both the halves
"""


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head:
            return True
        slow = head
        fast = head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        head2 = slow.next
        slow.next = None
        prev = None
        curr = head2
        nxt = ListNode()
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        head2 = prev
        while head and head2:
            if head.val != head2.val:
                return False
            head = head.next
            head2 = head2.next
        return True
