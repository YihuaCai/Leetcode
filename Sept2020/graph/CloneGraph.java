/**
 * 133. Clone Graph
 * https://leetcode.com/problems/clone-graph/
 * @author Yihua Cai
 **/
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    private Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return cloneNode(node);
    }

    private Node cloneNode(Node node) {
        if (node == null) return null;
        Node newnode = new Node(node.val);
        map.put(node, newnode);
        if (node.neighbors != null && node.neighbors.size() > 0) {
            for (Node n: node.neighbors) {
                if (map.containsKey(n)) {
                    newnode.neighbors.add(map.get(n));
                } else {
                    newnode.neighbors.add(cloneNode(n));
                }
            }
        }
        return newnode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
