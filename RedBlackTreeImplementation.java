public class RedBlackTreeImplementation {

    static final boolean RED = true;
    static final boolean BLACK = false;

    class Node {

        int data;
        boolean color;

        Node left, right, parent;

        Node(int data) {

            this.data = data;
            this.color = RED;
        }
    }

    Node root;

    void rotateLeft(Node node) {

        Node rightChild = node.right;

        node.right = rightChild.left;

        if (rightChild.left != null)
            rightChild.left.parent = node;

        rightChild.parent = node.parent;

        if (node.parent == null) {

            root = rightChild;

        } else if (node ==
                   node.parent.left) {

            node.parent.left =
                    rightChild;

        } else {

            node.parent.right =
                    rightChild;
        }

        rightChild.left = node;
        node.parent = rightChild;
    }

    void rotateRight(Node node) {

        Node leftChild = node.left;

        node.left = leftChild.right;

        if (leftChild.right != null)
            leftChild.right.parent = node;

        leftChild.parent = node.parent;

        if (node.parent == null) {

            root = leftChild;

        } else if (node ==
                   node.parent.right) {

            node.parent.right =
                    leftChild;

        } else {

            node.parent.left =
                    leftChild;
        }

        leftChild.right = node;
        node.parent = leftChild;
    }
}
