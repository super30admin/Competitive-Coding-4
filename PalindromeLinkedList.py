# Time Complexity - O(n)
# Space Complexity - O(1)

class Solution:
    def isPalindrome(self, head) -> bool:
        fast = head
        slow = head

       
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

       
        prev = None
        while slow:
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp

      
        left, right = head, prev
        while right:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next
        return True