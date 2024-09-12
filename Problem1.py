#Competitive Coding-4 
#Problem1 : https://leetcode.com/problems/palindrome-linked-list/
#All test cases passed on Leetcode
#Time Complexity-O(N) 
#Space Complexity-O(1)
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        
        #check base conditions
        if head==None or head.next==None:
            return True
        
        #find mid element
        #take two pointers
     
        slow=head
        fast=head.next
        while fast!=None and fast.next!=None:
            #move slow by 1x and fast y 2x speed
            fast=fast.next.next
            slow=slow.next
            
        #break the link
        head2=slow.next
        slow.next=None
        
        prev=None
        curr=head2
        
        #reverse the 2nd half
        while curr!=None:
            next=curr.next
            curr.next=prev
            prev=curr
            curr=next
        
        head2=prev
        
        #compare till one of them is null
        while head!=None and head2!=None:
            if head.val!=head2.val:
                return False
            head=head.next
            head2=head2.next
        return True