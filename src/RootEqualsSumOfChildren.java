// https://leetcode.com/problems/root-equals-sum-of-children
// T: O(1)
// S: O(1)

public class RootEqualsSumOfChildren {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
