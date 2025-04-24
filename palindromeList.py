class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:

    # Approach: Fast and Slow Pointer to find the middle, then reverse the second half
    # 1. Use a fast and slow pointer to find the middle of the linked list.
    # 2. Reverse the second half of the linked list.
    # 3. Compare the first half with the reversed second half to check if it's a palindrome.
    # TC: O(n) - Traverse through the list a few times (constant number of times)
    # SC: O(1) - No extra space used, only pointers and in-place modifications
    def isPalindrome(self, head):
        # base case for an empty or single-element list
        if not head or not head.next:
            return True

        # Step 1: Get the middle of the linked list
        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Step 2: Reverse the second half of the list
        prev = None
        while slow:
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp

        # Step 3: Compare the first and the reversed second half
        left, right = head, prev
        while right:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next

        return True


if __name__ == "__main__":
    # Test Case: Palindrome List -> 1 -> 2 -> 2 -> 1
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(2)
    head.next.next.next = ListNode(1)

    sol = Solution()
    print("Is Palindrome:", sol.isPalindrome(head))  # Output: True
