// Time Complexity : O(n) as we have to visit all nodes in order to get the node at each level
// Space Complexity : O(h) as the recursive stack can take that much space but in the worst case it will be O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Binary Tree Level Order Traversal
 * */

/*
 * Approach: Using Depth First Search
 * In this approach, we use dfs approach. We start from the root node and visit its children in the dfs manner.
 * Since, at every level we want to know what level we are at, we must maintain a level and the result list
 * as the parameters of recursion. We increment the level, as we go one step deep into the recursion. At every
 * level we check if there is a list initiated for that level, if not we declare one and start adding the node values
 * at every level for the corresponding list for a specific level.
 * */

import java.util.ArrayList;
import java.util.List;
import TreeNode;

public class BinaryTreeLevelOrderTraversal_usingDFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal_usingDFS binaryTreeLevelOrderTraversalUsingDFS = new BinaryTreeLevelOrderTraversal_usingDFS();
        System.out.println(binaryTreeLevelOrderTraversalUsingDFS.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    public void helper(TreeNode root, int level, List<List<Integer>> result) {
        // base case
        if(root == null) return;

        // logic
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        helper(root.left, level+1, result);
        helper(root.right, level+1, result);
    }
}
