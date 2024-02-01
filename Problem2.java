//Accepted on LT
//Just make a list and compare
//O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        ListNode cr= head;
        boolean odd = false;
        boolean checker = true;
        List<Integer> l = new ArrayList<>();

        while(cr!=null){
            l.add(cr.val);
            cr = cr.next;
        }
        int n = l.size();
        for (int i = 1; i < n; i++) {
            int e1 = l.get(i-1);
            int e2 = l.get(n-i);
            if(e1==e2){
                continue;
            }
            else{
                return false;
            }
        }


        return true;

        
    }
}