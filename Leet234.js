// Time Complexity : O(N)
// Space Complexity : constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    this.cur = head;
    var arr=[],i=0;
    while(this.cur!==null)
    {
        arr[i]=this.cur.val;
        this.cur = this.cur.next;
        i++;
    }
    var left=0,right= arr.length-1;
    while(left<=right)
    {
        if(arr[left]!==arr[right])
        {
            return false;
        }
        left++;
        right--;
    }
    return true;
};