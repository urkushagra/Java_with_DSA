public class ValidateBST {

    static Integer prev = null;

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)) return false;

        if (prev != null && root.val <= prev) return false;
        prev = root.val;

        return isValidBST(root.right);
    }
}
