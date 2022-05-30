// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
// T: O(n)
// S: O(n)

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    Map<Integer, Integer> inOrderIndices;
    int[] postOrder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inOrderIndices = getIndicesMap(inorder);
        this.postOrder = postorder;
        return buildTreePostIn(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTreePostIn(int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {
        if (postOrderStart > postOrderEnd || inOrderStart > inOrderEnd) return null;
        final TreeNode root = new TreeNode(postOrder[postOrderEnd]);
        int ri = inOrderIndices.get(postOrder[postOrderEnd]);
        root.left = buildTreePostIn(inOrderStart, ri - 1, postOrderStart, postOrderStart + ri - inOrderStart - 1);
        root.right = buildTreePostIn(ri + 1, inOrderEnd, postOrderStart + ri - inOrderStart, postOrderEnd - 1);
        return root;
    }

    private Map<Integer, Integer> getIndicesMap(int[] array) {
        final Map<Integer, Integer> result = new HashMap<>(array.length);
        for (int index = 0 ; index < array.length ; index++) {
            result.put(array[index], index);
        }
        return result;
    }
}
