import java.util.*;

public class Codec {

    public static String serialize(TreeNode root) {
        if (root == null) return "#";

        return root.val + "," +
                serialize(root.left) + "," +
                serialize(root.right);
    }

    static int index = 0;

    public static TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return build(nodes);
    }

    private static TreeNode build(String[] nodes) {
        if (nodes[index].equals("#")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[index++]));
        node.left = build(nodes);
        node.right = build(nodes);
        return node;
    }
}
