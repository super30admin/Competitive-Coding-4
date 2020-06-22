// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : forget set current.next = prev when reversing a linkedlist and did OR cindition checking when comparing two linkedlist
// find mid pointer. reverse second half. compare first half and reversed half


// Your code here along with comments explaining your approach

class Solution {
    func isPalindrome(_ root: ListNode?) -> Bool {
        var head: ListNode? = root
       //edge
        if head == nil {
            return true
        }
        
        //find mid pointer
        var prev: ListNode? = nil
        var slow = head
        var fast = head
        
        while(fast != nil && fast?.next != nil) {
            prev = slow
            slow = slow?.next  // 2
            fast = fast?.next?.next //nil
            print(slow)
            print(fast)
        }
        // print(slow?.val)

        //remove conection
        prev?.next = nil
        // print(prev?.val)
        //reverse from mid
        var midPrev: ListNode? = nil
        var current = slow
        var temp = current?.next //nil
        while(current != nil) {
            current?.next = midPrev  //issue here
            midPrev = current
            current = temp //nil
            temp = temp?.next //nil
        }
        
        print(midPrev?.val)
         print(head?.val)
        //compare head, prev
        
        while(head != nil && midPrev != nil) { // issue - used or condition 
            if head?.val != midPrev?.val {
                return false
            }
            head = head?.next
            midPrev = midPrev?.next
         print(midPrev?.val)
         print(head?.val)
        }
        
        return true
        
    }
}