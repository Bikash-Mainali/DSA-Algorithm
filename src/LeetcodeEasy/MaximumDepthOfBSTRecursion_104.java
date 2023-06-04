package LeetcodeEasy;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 8/22/22
 */
public class MaximumDepthOfBSTRecursion_104 {

    TreeNode root = null;

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            left = null;
            right = null;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    void insert(int v) {

        TreeNode newTreeNode = new TreeNode(v, null, null);
        if (root == null) {
            root = newTreeNode;
        } else {
            TreeNode n = root;
            boolean inserted = false;
            while (!inserted) {
                if (v < n.data) {
                    if (n.left == null) {
                        n.left = newTreeNode;
                        inserted = true;
                    } else {
                        n = n.left;
                    }
                } else if (v > n.data) {
                    if (n.right == null) {
                        n.right = newTreeNode;
                        inserted = true;
                    } else {
                        n = n.right;
                    }
                }
                //value x is equal to value found in TreeNode
                //--a duplicate value -- so
                //an exception is thrown
                else {
                    throw new IllegalArgumentException("Duplicate value passed in!");

                }
            }
        }
    }

    public void print() {
        printInOrder(root);
    }

    public TreeNode getRootTreeNode() {
        return root;
    }

    public int maxDepth(TreeNode root) {

        if (root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth((root.left)), maxDepth(root.right));
    }

    public void printInOrder(TreeNode TreeNode) {
        if (TreeNode != null) {
            printInOrder(TreeNode.left);
            System.out.println(TreeNode.data);
            printInOrder(TreeNode.right);
        }
    }

    public static void main(String[] args) {
        MaximumDepthOfBST_104 obj = new MaximumDepthOfBST_104();
        int arr[] = {20, 17, 30, 15, 19, 25, 35, 13, 16, 18, 31, 40};
        IntStream.of(arr).forEach(x -> obj.insert(x));
        //obj.print();
        System.out.println(obj.maxDepth(obj.getRootNode()));
    }
}
