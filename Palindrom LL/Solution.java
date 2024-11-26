//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null ) {
            return false;
        }
        int length =1;
        ListNode p = head;
        while(p.next != null) {
            p = p.next;
            length=length+1;
        }
         // length=length+1;
        
        int midpoint = 0;
        int flag=0;
        if(length%2 != 0) {
            midpoint = (length-1)/2;
            flag=1;
        } else {
            midpoint = length/2;
        }
        int[] arr = new int[midpoint];
        int cnt =0;
        p = head;
        System.out.println("Midpoint="+midpoint);
        while(cnt != midpoint) {
            arr[cnt] = p.val;
            System.out.println(p.val);
             p = p.next;
            cnt = cnt +1;
        }
        if(flag == 1) {
            p = p.next;
        }
        // p = p.next;
      //  System.out.println("We will start from: "+p.val);
     //   System.out.println("Cnt = "+cnt);
        int i=cnt-1;
        while(i>-1) {
             System.out.println(p.val+" and " + arr[i]);
            if(p.val != arr[i]) {
                return false;
            }
            p=p.next;
            i=i-1;
        }
        return true;
    }
}
