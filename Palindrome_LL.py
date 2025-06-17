###
# Approach - Use two pointers (slow and fast) to find the middle of the linked list.
# Then, reverse the second half of the list.
# Compare the first half with the reversed second half node by node.
# If all values match, it is a palindrome.
#
# Time complexity - O(n): One traversal to find the middle, one to reverse, and one to compare.
# Space complexity - O(1): Only a few pointers are used, no extra data structures.
###
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head):
        slow = head
        fast = head
        prev = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        prev_1 = None
        curr = slow
        while curr:
            newnode = curr.next
            curr.next = prev_1
            prev_1 = curr
            curr = newnode
        while prev_1:
            if prev.val != prev_1.val:
                return False
            prev = prev.next
            prev_1 = prev_1.next
        return True
    
    def main(self):
        # Create Linked List: 1 -> 2 -> 2 -> 1
        n1 = ListNode(1)
        n2 = ListNode(2)
        n3 = ListNode(2)
        n4 = ListNode(1)
        n1.next = n2
        n2.next = n3
        n3.next = n4

        # Check if it's a palindrome
        result = self.isPalindrome(n1)
        print("Is Palindrome:", result)

sol = Solution()
sol.main()