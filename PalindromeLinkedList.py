# Time Complexity : O(n)
# Space Complexity : O(1)
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseList(self, head):
        prev = None
        current = head
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        return prev

    def isPalindrome(self, head):
        if not head or not head.next:
            return True

        # Find the middle of the linked list using the fast and slow pointer approach.
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Reverse the second half of the linked list.
        second_half = self.reverseList(slow)
        first_half = head

        # Compare the first and second half of the list.
        while second_half:
            if first_half.val != second_half.val:
                return False
            first_half = first_half.next
            second_half = second_half.next

        return True

# Helper function to create linked lists from a list of values
def create_linked_list(values):
    if not values:
        return None
    head = ListNode(values[0])
    current = head
    for value in values[1:]:
        current.next = ListNode(value)
        current = current.next
    return head

# Example 1
values1 = [1, 2, 2, 1]
head1 = create_linked_list(values1)
sol = Solution()
print(sol.isPalindrome(head1))  # Output: True

# Example 2
values2 = [1, 2]
head2 = create_linked_list(values2)
print(sol.isPalindrome(head2))  # Output: False

# Example 3
values3 = [1, 2, 3, 2, 1]
head3 = create_linked_list(values3)
print(sol.isPalindrome(head3))  # Output: True