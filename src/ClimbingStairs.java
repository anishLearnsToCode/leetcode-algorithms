public class ClimbingStairs {
    private static final int[] result = new int[50];

    static {
        result[0] = result[1] = 1;
        for (int index = 2 ; index < result.length ; index++) {
            result[index] = result[index - 1] + result[index - 2];
        }
    }

    public static int climbStairs(int steps) {
        return result[steps];
    }
}
