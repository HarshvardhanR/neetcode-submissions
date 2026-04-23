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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ListNode curr1 = l1;
        ListNode curr2 = l2;

        while(curr1!=null){
            sb1.insert(0, curr1.val);
            curr1 = curr1.next;
        }

        while(curr2!=null){
            sb2.insert(0, curr2.val);
            curr2 = curr2.next;
        }

        String s1 = sb1.toString();
        String s2 = sb2.toString();

        String resultantString = String.valueOf(Integer.parseInt(s1) + Integer.parseInt(s2));
        ListNode newNode = new ListNode();

        int p = resultantString.length()-1;
        curr1 = newNode;
        while(p>=0){
            ListNode nNode = new ListNode(Integer.parseInt(resultantString.substring(p, p+1)));
            curr1.next = nNode;
            curr1 = nNode;
            p--;
        }
        return newNode.next;
    }
}
