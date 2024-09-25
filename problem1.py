# LinkedList Palindrome
# // Time Complexity :O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



def isPalindrome(self, head):
    if(head==None): return head
    slow=head
    fast=head
    while(fast.next!=None and fast.next.next !=None):           #first, find the midpoint of the list
        slow=slow.next
        fast=fast.next.next
    fast=reverse(slow.next)                                     #reverse the second half of the list
    slow.next=None
    slow=head
    while(slow!=None and fast!=None):                           #iterate through the first and reversed second half of the list and see if they all equal to each other
        if(slow.val!=fast.val):
            return False
        slow=slow.next
        fast=fast.next
    return True
    
def reverse(head):                                                 #function to reverse the linkedlist
    if(head==None): return head
    prev=None
    curr=head
    nex = head.next
    while(nex!=None):
        curr.next=prev
        prev=curr
        curr=nex
        nex=nex.next
    curr.next=prev
    return curr