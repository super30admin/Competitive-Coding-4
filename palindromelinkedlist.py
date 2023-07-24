#Time:O(n)
#Space:O(1)
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        fast=head
        slow=head
        
        while fast and fast.next:#middle
            fast=fast.next
            fast=fast.next
            slow=slow.next
            
        prev=None
        while slow:#reversing the pointer
            temp=slow.next
            slow.next=prev
            prev=slow
            slow=temp
            
         #check for the palindrome
        left,right=head,prev
        while right:
            if left.val!=right.val:
                return False
            left=left.next
            right=right.next
        return True
        