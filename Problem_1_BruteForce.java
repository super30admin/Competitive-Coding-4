// Time complexity - O(n)
// Space complexity - O(n)

// Add values to list and check list is pallindrome.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        
        return check(list);
    }
    
    private boolean check(List<Integer> list){
        int low = 0;
        int high = list.size()-1;
        while(low < high){
            if(!list.get(low).equals(list.get(high))){
            System.out.println(low+"-"+list.get(low));
            System.out.println(high+"-"+list.get(high));
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
