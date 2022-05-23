'''
time complexity: O(n)
space complexity: O(1)
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if(head.next==None):
            return True
        #1 find the middle element
        s = head
        f  = head
        while(f.next!=None and f.next.next!=None):
            s = s.next
            f = f.next.next
        
        #2 reverse it from that element
        
        ptr1=None
        ptr2=s.next
        ptr3=s.next.next
        
        s.next=None
        
        #1-2-3
        #p1 p2 p3
        
        while(ptr3!=None):
            temp=ptr2.next
            ptr2.next=ptr1
            ptr1=ptr2
            ptr2=ptr3
            ptr3=ptr2.next
        
        ptr2.next=ptr1
        
        
        #3check if it is pallindrome
        while(head!=None and ptr2!=None):
            if(head.val!=ptr2.val):
                return False
            head=head.next
            ptr2=ptr2.next
        
        
        return True       
        
        
        
        
        
        
        