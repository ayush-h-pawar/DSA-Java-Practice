public class LowestCommonAncestorBST {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static Node insert(Node root, int key) {
        if (root == null)
            return new Node(key);

        if (key < root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);

        return root;
    }

    static Node lca(Node root, int n1, int n2) {
        if (root == null)
            return null;

        if (n1 < root.data && n2 < root.data)
            return lca(root.left, n1, n2);

        if (n1 > root.data && n2 > root.data)
            return lca(root.right, n1, n2);

        return root; // Split point
    }

    public static void main(String[] args) {
        Node root = null;

        root = insert(root, 50);
        insert(root, 30);
        insert(root, 70);
        insert(root, 20);
        insert(root, 40);
        insert(root, 60);
        insert(root, 80);

        Node result = lca(root, 20, 40);
        System.out.println("LCA: " + result.data); // 30
    }
}
