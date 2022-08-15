# Time complexity: O(n)
# Space complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# SOLUTION - 1
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        slow = head
        fast = head
#         finding middle
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
#             reversing the second part of linked list
        prev = None
        while slow:
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp
            
#      check if palindrome   
        left = head
        right = prev
        
        while right:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next
        return True


      
      
# SOLUTION - 2
# Time complexity: O(n)
# Space complexity: O(n)
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        nums = []
        
        while head:
            nums.append(head.val)
            head = head.next
            
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            if nums[left] != nums[right]:
                return False
            left += 1
            right -= 1
            
        return True
