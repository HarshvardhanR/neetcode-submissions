/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> h1 = new HashMap();

        Node curr = head;
        while(curr!=null){
            Node newNode = new Node(curr.val);
            h1.put(curr, newNode);
            curr = curr.next;
        }

        curr = head;
        while(curr!=null){
            Node copy = h1.get(curr);
            copy.next = h1.get(curr.next);
            copy.random = h1.get(curr.random);
            curr = curr.next;
        }

        return h1.get(head);
    }
}
