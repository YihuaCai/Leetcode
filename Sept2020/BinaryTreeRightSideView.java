import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 * @author Yihua Cai
 **/

public class BinaryTreeRightSideView {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        dfs(0, root, ls);
        List<Integer> res = new ArrayList<>();
        for (List<Integer> s: ls) {
            res.add(s.get(s.size() - 1));
        }
        return res;
    }

    private void dfs(int depth, TreeNode node, List<List<Integer>> ls) {
        if (node == null) return;
        if (ls.size() == depth) {
            ls.add(new ArrayList<>());
        }

        ls.get(depth).add(node.val);

        dfs(depth + 1, node.left, ls);
        dfs(depth + 1, node.right, ls);
    }
}
