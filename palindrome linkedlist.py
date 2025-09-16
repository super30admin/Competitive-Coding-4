def isPalindrome(self, head: Optional[ListNode]) -> bool:
    slow=head
    fast=head
    while fast.next and fast.next.next:
        slow=slow.next
        fast=fast.next.next
    
    reversehead=self.reversefn(slow.next)
    # print(fast.val)
    slow.next=None
    slow=head
    fast=reversehead
    while slow and fast:
        if slow.val!=fast.val:
            return False
        slow=slow.next
        fast=fast.next
        
    return True



def reversefn(self,head):
    prev=None
    curr=head
    while curr:
        temp=curr.next
        curr.next=prev
        prev=curr
        curr=temp
        return prev
        