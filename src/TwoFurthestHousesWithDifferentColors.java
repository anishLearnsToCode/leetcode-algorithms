public class TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        int i = colors.length - 1;
        for ( ; i >= 0 && colors[i] == colors[0] ; i--);
        int distance = i;
        for (i = 0 ; i < colors.length && colors[i] == colors[colors.length - 1] ; i++);
        return Math.max(distance, colors.length - 1 - i);
    }
}
