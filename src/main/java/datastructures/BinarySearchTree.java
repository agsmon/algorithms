package datastructures;

public class BinarySearchTree <Key extends Comparable<Key>, Value>{
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node leftChild;
        private Node rightChild;
        private int size; // number of nodes in subtree rooted here

        public Node(Key key, Value value, int numberOfNodes) {
            this.key = key;
            this.value = value;
            this.size = numberOfNodes;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    public Value get(Key key) {
        return get(key, root);
    }

    public void put(Key key, Value value) {
        root = put(key, value, root);
    }

    private Value get(Key key, Node node) {
        if (node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare == 0) {
            return node.value;
        } else if (compare < 0) {
            return get(key, node.leftChild);
        } else {
            return get(key, node.rightChild);
        }
    }

    private Node put(Key key, Value value, Node node) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.leftChild = put(key, value, node.leftChild);
        } else if (compare > 0) {
            node.rightChild = put(key, value, node.rightChild);
        } else {
            node.value = value;
        }
        node.size = size(node.leftChild) + size(node.rightChild) + 1;
        return node;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.leftChild == null) {
            return node.rightChild;
        } else {
            node.leftChild = deleteMin(node.leftChild);
        }
        node.size = node.leftChild.size + node.rightChild.size + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(key, root);
    }

    private Node delete(Key key, Node node) {
        if (node == null) {
            return null;
        }
        int compare =  key.compareTo(node.key);
        if (compare < 0) {
            return delete(key, node.leftChild);
        } else if (compare > 0) {
            return delete(key, node.rightChild);
        } else {
            if (node.leftChild == null) {
                return node.rightChild;
            }
            if (node.rightChild == null) {
                return node.leftChild;
            }
            // if the node has two children,
            // the smallest node in the right subtree is the successor
            Node temp = node; // saving our node in temp variable
            node = min(temp.rightChild); // the smallest node in the right subtree replaces the node
            node.rightChild = deleteMin(temp.rightChild); // new right subtree without smallest node
            node.leftChild = temp.leftChild; // left subtree remains the same
        }
        node.size = node.leftChild.size + node.rightChild.size + 1;
        return node;
    }

    private Node min(Node node) {
        if (node.leftChild == null) {
            return node;
        } else {
            return min(node.leftChild);
        }
    }
}
