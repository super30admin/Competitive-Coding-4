# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

//Time Complexity: o(n)
//Space Complexity: o(1)
// Did the code run on leet code: yes

// Calculate the mid point of the linked list. from the mid reverse the other part of the linked list and compare both first half and second half.
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        if(head == None):
            return True
        if(head.next== None):
            return True
        curr = head
        count = 0
        while(curr):
            count +=1
            curr = curr.next
        mid = count/2
        curr = head
        
        while(mid>0):
            curr= curr.next
            mid = mid-1
        midnode = curr    
        midp = self.reverse(midnode)
        while(midp):
            if(midp.val !=head.val):
                return False
            midp = midp.next
            head = head.next
        return True    
                
    def reverse(self,root):
        prev = None
        curr = root
        while(curr):
            nextTemp = curr.next
            curr.next = prev
            prev = curr
            curr=  nextTemp
        print(prev.val)
        return prev
