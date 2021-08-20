#using slow and fast pointer - time- O(n)
#space - O(1) as we are spliting the list in two halves and reversing and checking if nodes are same

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        #traverse till end of the linked list to get mid 
        slow=head
        fast=head
        #finding mid point and reverse first half
        curr=head
        prev=None
        next_val=None
        while fast and fast.next:
            slow =slow.next
            fast=fast.next.next
            #reverse the first half all together
            next_val=curr.next
            curr.next=prev
            prev=curr
            curr=next_val

        #check if fast is at end so move slow to cross the middle value
        if fast:
            slow=slow.next
        #Traverse linked list second half and compare with reversed first half values
        while slow and prev:
            if slow.val!=prev.val:
                return False
            slow=slow.next
            prev=prev.next
        return True
        
        
        
