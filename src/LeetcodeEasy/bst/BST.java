package LeetcodeEasy.bst;

import java.util.LinkedList;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 12/12/21
 */

// here every subtree has root node
public class BST {

    Node root;


    void insert(int v) {

        if (root == null) {
            root = new Node(v);
        } else {
            //insert
            Node n = root;
            boolean inserted = false;
            while (!inserted) {
                if (v < n.data) {
                    if (n.left == null) {
                        n.left = new Node(v);
                        inserted = true;
                    } else {
                        n = n.left;
                    }
                } else if (v > n.data) {
                    if (n.right == null) {
                        n.right = new Node(v);
                        inserted = true;
                    } else {
                        n = n.right;
                    }
                }
                //value x is equal to value found in node
                //--a duplicate value -- so
                //an exception is thrown
                else {
                    throw new IllegalArgumentException(
                            "Duplicate value passed in!");

                }
            }
        }
    }

    //recursive
    Node insertRecr(Node n, int v) {
        return insertUsingRecursion(n, v);
    }

    public Node insertUsingRecursion(Node n, Integer v) {
        if (n == null) {
            return new Node(v);
        }
        // recur for the left subtree
        if (v < n.data) {
            n.left = insertUsingRecursion(n.left, v);
        }
        // otherwise, recur for the right subtree
        else {
            n.right = insertUsingRecursion(n.right, v);
        }
        return n;
    }

    public void printTree() {
        if (root == null)
            System.out.println("Empty tree");
        else
            display(root);
    }

    private void display(Node n) {
        if (n != null) {
            display(n.left);
            System.out.println(n.data);
            display(n.right);
        }
    }


    public boolean searchNode(Integer x) {
        if (x == null) return false;
        return findNode(x, root);
    }

    private boolean findNode(Integer x, Node n) {
        if (n == null) return false;
        if (n != null && n.data.equals(x)) return true;
        return (x.compareTo(n.data) < 0) ? findNode(x, n.left) : findNode(x, n.right);
    }

    public Node searchMinNode() {
        Node minNode = search(root);
        return minNode;
    }

    private Node search(Node n) {

        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
            search(n);
        }
        return n;
    }



    /**
     * Calls recursive find method to locate Node
     * to be removed; then
     * calls the recursive remove method to remove it.
     * Returns true if target Node is found and
     * is successfully removed, false otherwise
     *
     * @param val - Integer to be removed
     * @return true if found and removed, false otherwise
     */
    public boolean remove(int val) {
        Node node = findNode(val, root);
        if (node == null) {
            return false;
        }
        return removeNode(node);
    }

    private Node findNode(int val, Node n) {
        if (n == null)
            return null; //if no node is found then returns null at the end
        else if (n.data.equals(val))
            return n;
        if (val < n.data) {
            return findNode(val, n.left);
        } else {
            return findNode(val, n.right);
        }
    }

    private boolean removeNode(Node removeNode) {
        //case 1: a node having no children
        //in this case, we can just break the link
        //from node to its parent
        if (removeNode.left == null && removeNode.right == null) {
            Node parent = parent(removeNode);
            if (parent != null) {
                if (parent.left == removeNode) parent.left = null;
                if (parent.right == removeNode) parent.right = null;
            }
            return true;
        }
        //case 2: a node having left children
        //in these cases, add a link from parent to
        //child of node
        if (removeNode.left != null && removeNode.right == null) {
            Node parent = parent(removeNode);
            if (parent.left == removeNode) parent.left = removeNode.left;
            if (parent.right == removeNode) parent.right = removeNode.left;
            return true;
        }
        //case 3: a node having right children
        if (removeNode.left == null && removeNode.right != null) {
            Node parent = parent(removeNode);
            if (parent.left == removeNode) parent.left = removeNode.right;
            if (parent.right == removeNode) parent.right = removeNode.right;
            return true;
        }

        //case 4: a node having left and right children
        //complex form
        //in this case, find min to the right of node and
        //insert this value into the node; link up parent of
        //this min with right child of this min
        if (removeNode.left != null && removeNode.right != null) {
            Node min = search(removeNode.right);
            Node parentOfMin = parent(min);
            removeNode.data = min.data;
            parentOfMin.right = min.right;
            parentOfMin.left = null;
            return true;
        }
        return false;
    }

    private Node parent(Node t) {
        return parent(t, root, null);
    }

    private Node parent(Node t, Node n, Node parent) {
        if (n == null) return null;
        Integer val = t.data;
        if (n.data.equals(val)) return parent;
        if (val.compareTo(n.data) < 0) {
            return parent(t, n.left, n);
        } else {
            return parent(t, n.right, n);
        }
    }


    //in-order
    public LinkedList<Integer> inorder() {
        if (root == null) {
            return null;
        } else {
            return getInorder(new LinkedList<>(), root);
        }
    }


    public LinkedList<Integer> getInorder(LinkedList<Integer> list, Node n) {
        if (n == null || list == null) return list;
        if (n != null) {
            /* first recur on left child */
            getInorder(list, n.left);
            list.add(n.data);
            /* first recur on right child */
            getInorder(list, n.right);
        }
        return list;
    }


    //preorder
    public LinkedList<Integer> preorder() {
        if (root == null) {
            return null;
        } else {
            return getPreorder(new LinkedList<>(), root);
        }
    }

    public LinkedList<Integer> getPreorder(LinkedList<Integer> list, Node n) {
        if (n == null)
            return null;
        //System.out.print(n.data + " ");
        //add data
        list.add(n.data);
        /* recur on left subtree */
        getPreorder(list, n.left);
        /* now recur on right subtree */
        getPreorder(list, n.right);
        return list;
    }

    //post-order
    public LinkedList<Integer> postorder() {
        if (root == null) {
            return null;
        } else {
            return getPostorder(new LinkedList<>(), root);
        }
    }

    public LinkedList<Integer> getPostorder(LinkedList<Integer> list, Node n) {
        if (n == null)
            return null;
        /* recur on left subtree */
        getPostorder(list, n.left);
        /* now recur on right subtree */
        getPostorder(list, n.right);
        //add data
        list.add(n.data);
        return list;
    }


    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(50);
        bst.insert(30);
        bst.insert(60);
        bst.insert(20);
        bst.insert(40);
        bst.insert(55);
        bst.insert(70);

        //using recursion
        Node root = null;
        for (int data : new int[]{50, 30, 60, 20, 40, 55, 70}) {
            //root = bst.insertRecr(root, data);
        }
        System.out.println("display with recursion");
        bst.display(root);
        System.out.println("print with recursion");
        bst.printTree();
        System.out.println(bst.searchNode(21));
        System.out.println(bst.searchMinNode());
        //System.out.println(bst.remove(20));
        bst.printTree();

        //BST traversal order and print as List
        System.out.println("in-order: " + bst.inorder());
        System.out.println("pre-oreder: " + bst.preorder());
        System.out.println("post-oreder: " + bst.postorder());
    }
}
