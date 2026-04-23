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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            head = null;
            return head;
        }
        int length=1;
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
            length++;
        }
        if(n==length){
            temp = head;
            head = head.next;
            temp.next = null;
            return head;
        }
        else{
            temp = head;
            int looper = length-n-1;
            while(looper>0){
                temp = temp.next;
                looper--;
            }
            if(n==1){
                temp.next=null;
            }
            else{
                ListNode temp1 = temp.next.next;
                temp.next.next = null;
                temp.next = temp1;
            }
        }
        return head;
    }
}
