// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
// T: O(n)
// S: O(n)

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    Map<Integer, Integer> inOrderIndices;
    int[] postOrder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrderIndices = getIndicesMap(inorder);
        this.postOrder = postorder;
        return buildTreePostIn(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTreePostIn(int is, int ie, int ps, int pe){
        if (ps > pe || is > ie) return null;
        final TreeNode root = new TreeNode(postOrder[pe]);
        int ri = inOrderIndices.get(postOrder[pe]);
        root.left = buildTreePostIn(is, ri-1, ps, ps+ri-is-1);
        root.right = buildTreePostIn(ri+1, ie, ps+ri-is, pe-1);
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
