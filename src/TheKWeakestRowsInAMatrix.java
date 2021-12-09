import java.util.PriorityQueue;
import java.util.Queue;

public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        final Queue<Row> minHeap = new PriorityQueue<>();
        for (int index = 0 ; index < mat.length ; index++) {
            minHeap.add(Row.from(mat[index], index));
        }
        final int[] result = new int[k];
        for (int i = 0 ; i < result.length ; i++) {
            result[i] = minHeap.poll().index;
        }
        return result;
    }

    private static final class Row implements Comparable<Row> {
        private final int index;
        private final int soldiers;

        private Row(int index, int soldiers) {
            this.index = index;
            this.soldiers = soldiers;
        }

        @Override
        public int compareTo(Row other) {
            if (this.soldiers == other.soldiers) {
                return Integer.compare(this.index, other.index);
            }
            return Integer.compare(this.soldiers, other.soldiers);
        }

        private static Row from(int[] row, int index) {
            int soldiers = 0;
            for (int i = 0; i < row.length && row[i] == 1; i++) {
                soldiers++;
            }
            return new Row(index, soldiers);
        }
    }
}
