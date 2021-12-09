import java.util.PriorityQueue;
import java.util.Queue;

public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<Row> minHeap = new PriorityQueue<>();
        for (int[] row: mat) {
            minHeap.add()
        }
    }

    private record Row(int index, int soldiers) implements Comparable<Row> {

        @Override
        public int compareTo(Row other) {
            if (this.soldiers == other.soldiers) {
                return Integer.compare(this.index, other.index);
            }
            return Integer.compare(this.soldiers, other.soldiers);
        }

        private static Row from(int[] row, int index) {
            for (int)
        }
    }
}
