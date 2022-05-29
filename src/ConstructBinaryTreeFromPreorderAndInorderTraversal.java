// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
// T: O(n)
// S: O(n)

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int preOrderIndex = 0;
    Map<Integer, Integer> inOrderIndices;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrderIndices = buildValueToIndexMap(inorder);
        return buildTree(preorder, inorder, 0, preorder.length);
    }

    private TreeNode buildTree(int[] preOrder, int[] inOrder, int start, int end) {
        if (start >= end) return null;

        int inOrderIndex = inOrderIndices.get(preOrder[preOrderIndex]);
        final TreeNode root = new TreeNode(preOrder[preOrderIndex++]);
        root.left = buildTree(preOrder, inOrder, start, inOrderIndex);
        root.right = buildTree(preOrder, inOrder, inOrderIndex + 1, end);
        return root;
    }

    private Map<Integer, Integer> buildValueToIndexMap(int[] array) {
        final Map<Integer, Integer> result = new HashMap<>();
        for (int index = 0 ; index < array.length ; index++) {
            result.put(array[index], index);
        }
        return result;
    }
}
