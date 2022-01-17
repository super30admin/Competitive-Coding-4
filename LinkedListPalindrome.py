# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        
        if not head.next:
            return True
        
        slow = head
        fast = head
        
        '''Find Middle'''

        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        '''Split two lists'''
        head2 = slow.next
        slow.next = None
        
        '''Reverse second list'''
        prev = None
        curr = head2
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        
        l1 = head
        l2 = prev
        
        '''Palindrome check'''
        while l1 and l2:
            if l1.val != l2.val:
                return False
            l1 = l1.next
            l2 = l2.next
        
        
        return True