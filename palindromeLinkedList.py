class ListNode:
    def __init__(self,val=0,next=None):
        self.val=val
        self.next=next

class Solution:
    def isPalindrome(self,head):
        slow=fast=head
        while fast and fast.next:
            slow=slow.next
            fast=fast.next.next

        prev=None
        while slow:
            next_node=slow.next
            slow.next=prev
            prev=slow
            slow=next_node

        left,right=head,prev
        while right:
            if left.val != right.val:
                return False
            left=left.next
            right=right.next

        return True
    
def buildLinkedList(values):
    if not values:
        return None
    head=ListNode(values[0])
    current=head
    for val in values[1:]:
        current.next=ListNode(val)
        current=current.next
    return head

def printLinkedList(head):
    while head:
        print(head.val,end="->"if head.next else "")
        head=head.next
    print()

values=[1,2,2,1]
head=buildLinkedList(values)
print("Input: " )
printLinkedList(head)

sol=Solution()
print(sol.isPalindrome(head))