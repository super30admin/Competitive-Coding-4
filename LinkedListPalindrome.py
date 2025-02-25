class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        #Brute Force : T.C and S.C --> O(N)
        # array = list()
        # curr = head
        # while curr:
        #     array.append(curr.val)
        #     curr=curr.next
        # n = len(array)
        # l,r = 0,n-1
        # while(l<r):
        #     if(array[l]!=array[r]):
        #         return False
        #     l+=1
        #     r-=1
        # return True

        #Optimized : T.C --> O(N), S.C --> O(1)
        slow = head
        fast = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
        prev = None
        while slow:
            temp = slow.next
            slow.next = prev
            prev = slow
            slow = temp
        l,r=head,prev
        while r:
            if(l.val!=r.val):
                return False
            l=l.next
            r=r.next
        return True