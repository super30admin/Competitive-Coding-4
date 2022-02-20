#Time Complexity O(N)
#Space Complexity O(N)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        temp  = head
        res = []
        while temp !=None:
            res.append(temp.val)
            temp = temp.next
        low=0
        high = len(res)-1
        
        
        while low<=high:
            if res[low] !=res[high]:
                return False
            low+=1
            high-=1
            
        return True
            
            
        
        
        
        
