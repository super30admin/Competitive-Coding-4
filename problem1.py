# Time Complexity: O(n)
# Space Complexity: O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        answer = True
        slptr = head
        fastptr = head
        while fastptr.next != None and fastptr.next.next != None:
            slptr = slptr.next
            fastptr = fastptr.next.next 
        curr = slptr.next
        slptr.next = None
        prev = None
        while curr != None:
            forward = curr.next
            curr.next = prev
            prev = curr
            curr = forward
            
        it1 = head
        it2 = prev
        while it1 != None and it2 != None:
            if it1.val != it2.val:
                return False
            it1 = it1.next
            it2 = it2.next
            
        return answer
                
        
            