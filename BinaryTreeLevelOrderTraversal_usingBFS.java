// Time Complexity : O(n) as we have to visit all the nodes at all levels
// Space Complexity : O(n) as we use a queue to store nodes at each level
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * Problem: Binary Tree Level Order Traversal
 * */

/*
 * Approach: Using Breadth First Search
 * In this approach, we use breadth first search starting from the root nodes by storing them in a queue. Every time
 * we pop a node from the queue, we process it and store their children in the queue. At every subsequent level,
 * we do not know how many nodes we should be popping which is why we use a size variable to do that.
 * We keep processing each level and all nodes belonging to one level in a list. Once, we are done processing the level,
 * we can add this list to the result list. We keep doing it until the queue is empty.
 * */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import TreeNode;

public class BinaryTreeLevelOrderTraversal_usingBFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal_usingBFS binaryTreeLevelOrderTraversalUsingBFS = new BinaryTreeLevelOrderTraversal_usingBFS();
        System.out.println(binaryTreeLevelOrderTraversalUsingBFS.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();

                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }

        return result;
    }
}
