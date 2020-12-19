public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);

        while (width > 0) {
            if (area % width == 0) {
                return new int[] {area / width , width};
            }
            width--;
        }

        return new int[] {area , 1};
    }
}
