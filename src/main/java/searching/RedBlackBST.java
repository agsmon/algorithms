package searching;

// red-black binary search tree
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        Key key;            // key
        Value value;        // associated value
        Node leftChild;
        Node rightChild;    // subtrees
        int subtreeNodes;   // number of nodes in subtree (including itself)
        boolean color;      // color link from parent to this node

        public Node(Key key, Value value, int subtreeNodes, boolean color) {
            this.key = key;
            this.value = value;
            this.subtreeNodes = subtreeNodes;
            this.color = color;
        }
    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
    }

    // rotation switches the orientation of red links
    private Node rotateLeft(Node node) {
        return node;
    }

    private Node rotateRight(Node node) {
        return node;
    }

    private void changeColors(Node node) {

    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.subtreeNodes;
        }
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) { // standart insert with red link to parent
            return new Node(key, value, 1, RED);
        }

        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.leftChild = put(node.leftChild, key, value);
        } else if (compare > 0) {
            node.rightChild = put(node.rightChild, key, value);
        } else {
            node.value = value;
        }

        if (isRed(node.rightChild) && !isRed(node.leftChild)) {
            node = rotateLeft(node);
        }
        if (isRed(node.leftChild) && isRed(node.leftChild.leftChild)) {
            node = rotateRight(node); // why?
        }
        if (isRed(node.leftChild) && isRed(node.rightChild)) {
            changeColors(node);
        }

        node.subtreeNodes = node.leftChild.subtreeNodes + node.rightChild.subtreeNodes + 1;

        return node;
    }

}
