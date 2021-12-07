public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int people) {
        final int[] result = new int[people];
        for (int i = 0, k = 1 ; candies > 0 ; k++, i = (i + 1) % people) {
            result[i] += Math.min(candies, k);
            candies -= Math.min(candies, k);
        }
        return result;
    }
}
