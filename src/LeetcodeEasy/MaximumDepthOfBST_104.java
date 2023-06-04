package LeetcodeEasy;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 8/22/22
 */
public class MaximumDepthOfBST_104 {

    Node root = null;

    public class Node {
        int data;
        Node left;
        Node right;

        Node() {
            left = null;
            right = null;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void insert(int v) {

        Node newNode = new Node(v, null, null);
        if (root == null) {
            root = newNode;
        } else {
            Node n = root;
            boolean inserted = false;
            while (!inserted) {
                if (v < n.data) {
                    if (n.left == null) {
                        n.left = newNode;
                        inserted = true;
                    } else {
                        n = n.left;
                    }
                } else if (v > n.data) {
                    if (n.right == null) {
                        n.right = newNode;
                        inserted = true;
                    } else {
                        n = n.right;
                    }
                }
                //value x is equal to value found in node
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

    public Node getRootNode() {
        return root;
    }

    public int maxDepth(Node root) {
        //using BFS/Queue
        Node current = root;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Node topNode = queue.poll();
                if (topNode.left != null) {
                    queue.add(topNode.left);
                } else if (topNode.right != null) {
                    queue.add(topNode.right);
                }
            }
            level++;
        }
        return level;
    }

    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.data);
            printInOrder(node.right);
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
