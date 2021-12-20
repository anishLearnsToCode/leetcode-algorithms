import java.util.ArrayList;
import java.util.List;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        final List<BoxType> boxes = getBoxTypesFrom(boxTypes);
        boxes.sort(BoxType::compareTo);
        int units = 0;
        for (BoxType box : boxes) {
            if (box.number <= truckSize) {
                units += box.units * box.number;
                truckSize -= box.number;
            } else {
                units += box.units * truckSize;
                break;
            }
        }
        return units;
    }

    private List<BoxType> getBoxTypesFrom(int[][] boxes) {
        final List<BoxType> boxTypes = new ArrayList<>();
        for (int[] box : boxes) {
            boxTypes.add(new BoxType(box[0], box[1]));
        }
        return boxTypes;
    }

    private static final class BoxType implements Comparable<BoxType> {
        private final int number;
        private final int units;

        private BoxType(int number, int units) {
            this.number = number;
            this.units = units;
        }

        @Override
        public int compareTo(BoxType o) {
            return Integer.compare(o.units, this.units);
        }
    }
}
