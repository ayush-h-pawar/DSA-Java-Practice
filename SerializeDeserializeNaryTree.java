import java.util.*;

public class SerializeDeserializeNaryTree {

    static class Node {

        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public String serialize(Node root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        serializeHelper(root, sb);

        return sb.toString();
    }

    private void serializeHelper(
            Node node,
            StringBuilder sb) {

        sb.append(node.val)
          .append(",")
          .append(node.children.size())
          .append(",");

        for (Node child : node.children) {
            serializeHelper(child, sb);
        }
    }

    public Node deserialize(String data) {

        if (data == null || data.isEmpty()) {
            return null;
        }

        Queue<String> queue =
                new LinkedList<>(
                        Arrays.asList(data.split(","))
                );

        return deserializeHelper(queue);
    }

    private Node deserializeHelper(
            Queue<String> queue) {

        int value =
                Integer.parseInt(queue.poll());

        int childCount =
                Integer.parseInt(queue.poll());

        Node node = new Node(value);

        for (int i = 0; i < childCount; i++) {
            node.children.add(
                    deserializeHelper(queue)
            );
        }

        return node;
    }

    public static void main(String[] args) {

        SerializeDeserializeNaryTree codec =
                new SerializeDeserializeNaryTree();

        Node root = new Node(1);

        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));

        String serialized =
                codec.serialize(root);

        System.out.println(serialized);

        Node restored =
                codec.deserialize(serialized);

        System.out.println(restored.val);
    }
}
