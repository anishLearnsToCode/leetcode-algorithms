// https://leetcode.com/problems/count-tested-devices-after-test-operations
// T: O(N)
// S: O(1)

public class CountTestedDevicesAfterTestOperations {
    public int countTestedDevices(int[] batteryPercentages) {
        int testedDevices = 0;
        for (int percentage : batteryPercentages) {
            if (percentage - testedDevices > 0) {
                testedDevices++;
            }
        }

        return testedDevices;
    }
}
