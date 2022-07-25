# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        arr = []
        temp = head
        while(temp != None):
            arr.append(temp.val)
            temp = temp.next
            
        arr.reverse()
        # print(arr)

        
        n = len(arr)
        i = 0
        
        while(head != None and i < n):
            
            if head.val != arr[i]:
                return False
        
            head = head.next
            i = i + 1
                
        return True
            