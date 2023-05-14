package LeetcodeEasy.bst;

/**
 * @PROJECT IntelliJ IDEA
 * @AUTHOR Bikash Mainali
 * @DATE 12/12/21
 */

class Node {
     Integer data; // The data in the node
     Node left; // Left child
     Node right; // Right child

    Node(Integer theElement) {
        this(theElement, null, null);
    }

    Node(Integer element, Node left, Node right) {
        this.data = element;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return data.toString();
    }
}
