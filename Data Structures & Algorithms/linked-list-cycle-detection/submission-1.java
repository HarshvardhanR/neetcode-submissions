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
    public boolean hasCycle(ListNode head) {
        HashSet<Integer> h1 = new HashSet<>();
        ListNode dummy = head;
        while(dummy!=null){
            if(h1.contains(dummy.val)){
                return true;
            }
            h1.add(dummy.val);
            dummy = dummy.next;
        }
        return false;
    }
}
