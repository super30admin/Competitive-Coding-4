# The code defines an isPalindrome method to determine if a linked list represents a palindrome.
# A linked list is considered a palindrome if its elements read the same forward and backward.

# Step 1: Find the Middle of the List
#   - Use two pointers, 'slow' and 'fast':
#       - 'slow' moves one step at a time, while 'fast' moves two steps at a time.
#       - When 'fast' reaches the end of the list, 'slow' will be at the middle of the list.
#   - This splits the list into two halves.

# Step 2: Reverse the Second Half of the List
#   - Reverse the second half of the list starting from 'slow' (the middle pointer):
#       - Use a 'prev' pointer initialized to None to reverse the direction of the links.
#       - Traverse the second half of the list while updating the next pointers to point backward.
#       - At the end of this step, 'prev' points to the head of the reversed second half.

# Step 3: Check for Palindrome
#   - Use two pointers, 'left' (starting from the head of the list) and 'right' (starting from the head of the reversed second half).
#   - Compare the values at 'left' and 'right' for each step:
#       - If any pair of values differs, return False as the list is not a palindrome.
#       - Otherwise, move both pointers forward.
#   - If all values match, return True, indicating the list is a palindrome.

# Final Result:
#   - The method returns True if the linked list is a palindrome; otherwise, it returns False.

# TC: O(n) - The list is traversed multiple times: once to find the middle, once to reverse the second half, and once to compare values.
# SC: O(1) - The space complexity is constant as no additional data structures are used; only pointers are manipulated.


from typing import Optional


class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        slow = head
        fast = head

        #Middle
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        #Reverse
        prev = None
        while slow:
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp
        
        #Palindrome Check
        left, right = head, prev

        while right:
            if left.val != right.val:
                return False
            
            left = left.next
            right = right.next

        return True
