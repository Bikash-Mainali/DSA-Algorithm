package binary_tree;

public class L01_Insertion {

    private static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }
        if(data < root.data) {
            root.left = insert(root.left, data);
        }
        else if(data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }

    //print preorder
    private static void printPreOrder(Node root) {

        if(root.left != null) {
            printPreOrder(root.left);
        }
        System.out.println(root.data);
        printPreOrder(root.right);
        System.out.println(root.data);
    }


    public static void main(String[] args) {
        int[] arr = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        Node root = null;

        // Creating the following BST
        //      50
        //     /  \
        //    30   70
        //   / \   / \
        //  20 40 60 80

        root = insert(root, 50);
        root = insert(root, 30);
        //root = insert(root, 20);
        //root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        //root = insert(root, 80);

        root = insert(root, 90);

    }
}
