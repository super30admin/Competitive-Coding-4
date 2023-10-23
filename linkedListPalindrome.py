# find the mid-point using fast and slow pointers
# reverse the 2nd half of the list
# check for similar elements in the 2nd half of list 

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        slow,fast = head ,head 

        # reach the mid-point
        while fast and fast.next :
            fast = fast.next.next
            slow = slow.next

        # since mid is found , we have to 
        # sort the 2nd half of linked list
        prev = None 

        while slow :
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp
        
        # compare the two halves 
        left , right = head , prev
        while right :
            if(left.val) != (right.val):
                return False
            left = left.next
            right = right.next

        return True
            
            
