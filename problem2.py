// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if not head:
            return True
        slow=fast=head
        while fast and fast.next: //traverse the list to find mid node and create two seperate lists
            slow=slow.next
            fast=fast.next.next

        fast=slow.next
        slow.next=None
        
        pre=None      //reverse the second list which starts from (mid+1)th node
        while fast:
            nextt=fast.next
            fast.next=pre
            pre=fast
            fast=nextt
                
        
        while pre:    //compare two lists 
            if pre.val!=head.val:   //if at any point nodes of two lists no not have same elements => list is not a palindrom list
                return False
            pre=pre.next
            head=head.next
            
        if head and head.next:    //since there can be chances that first list has two extra nodes then we need to compare the values of those two nodes as well if the values are not same the again the list is not palindrom list
            if head.val!=head.next.val:
                return False
        
        return True // else list is palindrom list hence we return True
        
