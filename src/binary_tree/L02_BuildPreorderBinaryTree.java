package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class L02_BuildPreorderBinaryTree {
    static int index = 0;

    // Build Balanced BST from preorder array
    private static Node buildTree(int[] arr, int min, int max) {
        if (index >= arr.length) {
            return null;
        }

        int currentValue = arr[index];
        // Value must be in valid BST range
        if (currentValue < min || currentValue > max) {
            return null;
        }

        // Create the root node
        Node root = new Node(currentValue);
        index++;

        // All values smaller than root go to the left subtree
        root.left = buildTree(arr, min, currentValue);

        // All values greater than root go to the right subtree
        root.right = buildTree(arr, currentValue, max);

        return root;
    }

    // Print Preorder Traversal
    public static List<Integer> preorderPrint(Node root, List<Integer> result) {
        if (root == null) {
            return null;
        }
        result.add(root.data);
        preorderPrint(root.left, result);
        preorderPrint(root.right, result);
        return result;
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12, -13};
        Node root = buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Preorder of constructed tree:");
        System.out.println(preorderPrint(root, new ArrayList<>()));
    }

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }
}
