class Solution {
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        helper(node);
        return map.get(node);
    }

    public void helper(Node node){
        if(node == null) return;

        if(map.containsKey(node)) return;

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for(Node neighbor : node.neighbors){
            helper(neighbor);
            newNode.neighbors.add(map.get(neighbor));
        }
    }
}