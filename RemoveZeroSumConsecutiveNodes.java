// Time Complexity - O(n)
// Space Complexity - O(n)
// Approach - Used running sum approach -- also note some leetcode testcases seems incorrect confirm once
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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        Integer rSum = 0;
        Integer idx = 0;
        ListNode temp = head;
        ListNode prev = head;
        ListNode curr = head;
        int idx1 = 0; int idx2 = 0;
        int max = -99999;
        if(temp==null || temp.next==null && temp.val!=0) return head;
        while(temp!=null){
            // pRsum = rSum;
            rSum += temp.val;
            if(map.containsKey(rSum)){
                // idx1 = map.get(rSum)+1;
                if(idx2-map.get(rSum)>=max){
                    max = idx2-map.get(rSum);
                    idx1 = map.get(rSum)+1;
                    idx = idx2;
                }
            }else{
                map.put(rSum,idx2);
            }
            
            temp = temp.next;
            idx2++;
        }
        System.out.println(map+" "+idx1+" "+idx);
        int count = 0;
        while(idx1!=0 && count<idx1-1){
            prev = prev.next;
            count++;
        }
        count = 0;
        while(count<idx){ 
            curr = curr.next;
            count++;
        }
        if(idx1==0 && idx==0 && head.val!=0) return head;
        if(idx1==0) head = curr.next;
        prev.next = curr.next;
        // count = 0;
        // while(count<=idx-idx1){
        //     if(curr==null) break;
        //     curr = curr.next;
        //     count++;
        // }
        // if(idx1==0) head = curr;
        // head.next = curr;

        return head;

    }
}