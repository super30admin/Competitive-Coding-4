# Time Complexity :O(n) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : No
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        fast=head
        slow=head
#         Finding the mid element
        while fast and fast.next:
            fast=fast.next.next
            slow=slow.next
#        Changinng the pointers
        prev=None
        while slow:
            temp=slow.next
            slow.next=prev
            prev=slow
            slow=temp
# Itearte thorugh the linked list
        
        left=head
        right=prev
        while right:
            if left.val != right.val:
                return False
            left=left.next
            right=right.next
        return True