# Time Complexity : O(n), where n is the length of the list.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach
class Solution(object):
    # This problem is solved by traversing to the middle of the list and reversing
    # the second half of the list and checking for the two halves to be identical.
    def isPalindrome(self, head):
        # edge case
        if not head or not head.next:
            return True
        # pointers init
        slow, fast = head, head
        # reaching the middle of the list
        while fast.next != None and fast.next.next != None:
            slow = slow.next
            fast = fast.next.next
        # reversing second half
        h2 = self.reverse(slow.next)
        # comparing the two halves to be a palindrome
        while h2 != None and head != None:
            if h2.val != head.val:
                return False
            h2 = h2.next
            head = head.next
        return True

    # code for reversing the list
    def reverse(self, head):
        prev, next = None, head.next

        while next != None:
            head.next = prev
            prev = head
            head = next
            next = next.next
        head.next = prev
        return head
