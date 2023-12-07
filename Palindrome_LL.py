# TC:O(N)
# SC:O(1)

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
  def reverse(self,head):
    prev=None
    cur=head
    while cur!=None:
      fwd=cur.next
      cur.next=prev
      prev=cur
      cur=fwd
    return prev

  def isPalindrome(self, head: Optional[ListNode]) -> bool:
    if head==None or head.next==None:
      return True

    slow=head
    fast=head
    while fast.next and fast.next.next:
      slow=slow.next
      fast=fast.next.next

    print(slow.val)
    print(fast.val)
    
    head1=self.reverse(slow.next)
    slow.next=None

    ptr1=head
    ptr2=head1

    while ptr1!=None and ptr2!=None:
      if ptr1.val!=ptr2.val:
        return False
      ptr1=ptr1.next
      ptr2=ptr2.next

    return True


    print(head1.val)




        