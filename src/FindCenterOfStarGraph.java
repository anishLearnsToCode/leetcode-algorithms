public class FindCenterOfStarGraph {
    public int findCenter(int[][] edges) {
        return commonVertex(edges[0], edges[1]);
    }

    private int commonVertex(int[] e1, int[] e2) {
        if (e1[0] == e2[0] || e1[0] == e2[1]) return e1[0];
        return e1[1];
    }
}
