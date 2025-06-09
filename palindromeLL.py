"""
Use slow, fast to reach middle of the list
From middle, reverse second half of the list
Compare nodes from start (head) and from reversed half for palindrome
"""
"""
Time Complexity: O(n) — Traverse list - find middle, reverse and to compare
Space Complexity: O(1) — Reversal is in-place
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class palindromeLL:
    def isPalindrome(self, head: ListNode) -> bool:
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        def reverse(node):
            prev = None
            while node:
                temp = node.next
                node.next = prev
                prev = node
                node = temp
            return prev

        second_half = reverse(slow)
        first_half = head

        while second_half:
            if first_half.val != second_half.val:
                return False
            first_half = first_half.next
            second_half = second_half.next

        return True


if __name__=="__main__":

    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(2)
    head.next.next.next = ListNode(1)

    obj = palindromeLL()
    print(obj.isPalindrome(head))

