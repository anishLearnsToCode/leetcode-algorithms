// https://leetcode.com/problems/time-needed-to-inform-all-employees
// T: O(n)
// S: O(n)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {
    private static final class TreeNode {
        int val;
        List<TreeNode> subordinates = new ArrayList<>();

        TreeNode(int val) {
            this.val = val;
        }

        private boolean hasSubordinates() {
            return subordinates.size() > 0;
        }

        private void addSubordinate(TreeNode subordinate) {
            this.subordinates.add(subordinate);
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        TreeNode company = createEmployeeGraph(headID, manager);
        return timeNeededForInformationDispersal(company, informTime);
    }

    private int timeNeededForInformationDispersal(TreeNode root, int[] informTime) {
        if (root == null || !root.hasSubordinates()) return 0;
        int timeTaken = 0;
        for (TreeNode subordinate : root.subordinates) {
            timeTaken = Math.max(timeTaken, timeNeededForInformationDispersal(subordinate, informTime));
        }
        return timeTaken + informTime[root.val];
    }

    private TreeNode createEmployeeGraph(int headIndex, int[] managers) {
        final TreeNode root = new TreeNode(headIndex);
        final Map<Integer, TreeNode> employees = new HashMap<>();
        employees.put(headIndex, root);
        for (int i = 0 ; i < managers.length ; i++) {
            int managerId = managers[i];
            if (managerId == -1) continue;
            TreeNode manager = employees.getOrDefault(managerId, new TreeNode(managerId));
            TreeNode subordinate = employees.getOrDefault(i, new TreeNode(i));
            manager.addSubordinate(subordinate);
            if (!employees.containsKey(managerId)) employees.put(managerId, manager);
            if (!employees.containsKey(i)) employees.put(i, subordinate);
        }
        return root;
    }
}
