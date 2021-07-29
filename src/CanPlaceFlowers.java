public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        return flowersCapacity(flowerbed) >= n;
    }

    private int flowersCapacity(int[] flowerbed) {
        int capacity = 0;
        for (int index = 0 ; index < flowerbed.length ; index++) {
            if ((flowerbed[index] != 1) && (index == 0 || flowerbed[index - 1] == 0) && (index == flowerbed.length - 1 || flowerbed[index + 1] == 0)) {
                capacity++;
                flowerbed[index] = 1;
            }
        }
        return capacity;
    }
}
