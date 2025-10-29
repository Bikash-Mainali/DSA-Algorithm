package binary_tree;

public class L03_BuildInorderBinaryTree {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    // Build Balanced BST from sorted inorder array
    private static Node buildBSTFromInorder(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = buildBSTFromInorder(arr, start, mid - 1);
        root.right = buildBSTFromInorder(arr, mid + 1, end);

        return root;
    }

    // Print Inorder Traversal
    private static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = {1, 5, 7, 8, 10, 12};
        Node root = buildBSTFromInorder(inorder, 0, inorder.length - 1);

        System.out.println("Inorder of constructed BST:");
        printInorder(root);
    }
}
