public class TeemoAttacking {
    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[] {1, 2}, 2));
    }

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int poisonDuration = 0;
        for (int i = 0, current = timeSeries[0] - 1 ; i < timeSeries.length; i++) {
            poisonDuration += duration - Math.max(0, Math.max(current, timeSeries[i] - 1) - timeSeries[i] + 1);
            current = timeSeries[i] + duration - 1;
        }
        return poisonDuration;
    }
}
