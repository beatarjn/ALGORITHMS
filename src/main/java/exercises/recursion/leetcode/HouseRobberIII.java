package exercises.recursion.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class HouseRobberIII {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        int max = 0;

        if (root.left != null) {
            max += rob(left.left) + rob(left.right);
        }

        if (root.right != null) {
            max += rob(right.left) + rob(right.right);
        }

        return Math.max(max + root.val, rob(left) + rob(right));
    }

    public int robMemo(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return memo(root, map);
    }

    public int memo(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        int max = 0;

        if (root.left != null) {
            max += memo(left.left, map) + memo(left.right, map);
        }

        if (root.right != null) {
            max += memo(right.left, map) + memo(right.right, map);
        }
        map.put(root, Math.max(max + root.val, memo(left, map) + memo(right, map)));
        return Math.max(max + root.val, memo(left, map) + memo(right, map));
    }

    public int dp(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        TreeNode left = root.left;
        TreeNode right = root.right;

        int take = root.val;
        if (left != null) {
            queue.add(left);
        }
        if (right != null) {
            queue.add(right);
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                take += node.left.val;
                if (node.left.left != null) {
                    queue.add(node.left.left);
                }
                if (node.left.right != null) {
                    queue.add(node.left.right);
                }
            }
            if (node.right != null) {
                take += node.right.val;
                if (node.right.left != null) {
                    queue.add(node.right.left);
                }
                if (node.right.right != null) {
                    queue.add(node.right.right);
                }
            }
        }

        int notTake = 0;
        if (left != null) {
            notTake += left.val;
            if (left.left != null) {
                queue.add(left.left);
            }
            if (left.right != null) {
                queue.add(left.right);
            }

        }
        if (right != null) {
            notTake += right.val;
            if (right.left != null) {
                queue.add(right.left);
            }
            if (right.right != null) {
                queue.add(right.right);
            }
        }

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                notTake += node.left.val;
                if (node.left.left != null) {
                    queue.add(node.left.left);
                }
                if (node.left.right != null) {
                    queue.add(node.left.right);
                }
            }
            if (node.right != null) {
                notTake += node.right.val;
                if (node.right.left != null) {
                    queue.add(node.right.left);
                }
                if (node.right.right != null) {
                    queue.add(node.right.right);
                }
            }
        }

        return Math.max(take, notTake);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}