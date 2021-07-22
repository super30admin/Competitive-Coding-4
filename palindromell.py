# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        m=0
        slow=head
        temp=[]
        while slow!=None:
            m+=1
            slow=slow.next
        l=m//2
        while l>0:
                temp.append(head.val)
                head=head.next
                l-=1
        if m%2==0:
            pass
        else:
            head=head.next
        while head!=None:
                if head.val!=temp.pop():
                    return False
                head=head.next
        return True  
        