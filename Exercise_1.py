#Time Complexity : O(N), N being length of array
#Space Complexity : O(1), because not extra array is created.
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Got stuck on the reverse function for a bit.

#Your code here along with comments explaining your approach in three sentences only
'''Using slow and fast pointer, find the mid value and split the list in half. Then, 
reverse the second, and check that the two lists are equal
'''
class Solution:
    #reverse a linked list. 
    def reverse(self, head):
        head2 = head
        if head2!=None:
            next_node = head2.next
            head2.next = None

            while(next_node!=None):
                temp = next_node
                next_node = next_node.next
                temp.next = head2
                head2 = temp
                
        return head2        


    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        #find the mid value and split the list in half. 
        slow = head
        fast = head
        if slow==None:
            return True
        if slow.next==None:
            return True
        while(fast!=None):
            prev = slow
            slow = slow.next
            fast = fast.next

            if fast!=None:
                fast = fast.next

        #split and reverse the second list. 
        head2 = prev.next
        prev.next = None
        head1 = head
        head2=self.reverse(head2)
    
        #check that the two lists are equal if they are equal length. 
        while(head2!=None):
            if head1.val!=head2.val:
                return False
            head1 = head1.next
            head2 = head2.next

        #check any remaining values are the same. Return True.
        if head1!=None:
            temp = head1.val
            head1 = head1.next
            if head1!=None:
                if head1.val!= temp:
                    return False
        return True
            


