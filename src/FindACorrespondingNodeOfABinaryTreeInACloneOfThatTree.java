// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
// T: O(N)
// S: O(log(n))

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }

        if (original == target) return cloned;

        TreeNode leftAnswer = getTargetCopy(original.left, cloned.left, target);
        TreeNode rightAnswer = getTargetCopy(original.right, cloned.right, target);

        if (leftAnswer != null) return leftAnswer;
        return rightAnswer;
    }
}
