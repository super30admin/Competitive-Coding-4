'''
    Time Complexity:
        O(n) (because each node is visited once)

    Space Complexity:
        O(n) (because of the memory stack required)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Start from root and recurr until the end of the list.
        Check the equality of the values of these two nodes.
        Move the current head to head.next.
        On the way back (i.e, implicit memory stack.pop()), you will, by recursion, be checking the second and the second last nodes.
'''
class Solution:
    def __init__(self):
        self.curr_head = None

    def isPalindrome(self, head: ListNode) -> bool:
        self.curr_head = head

        return self.is_palindrome(head)

    def is_palindrome(self, node):
        if not node:
            return True

        if not self.is_palindrome(node.next):
            return False

        if self.curr_head.val != node.val:
            return False

        self.curr_head = self.curr_head.next
        return True
