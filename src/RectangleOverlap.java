public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        Rectangle rectangle1 = new Rectangle(rec1);
        Rectangle rectangle2 = new Rectangle(rec2);
        return hasXIntersection(rectangle1, rectangle2) && hasYIntersection(rectangle1, rectangle2);
    }

    private boolean hasXIntersection(Rectangle rec1, Rectangle rec2) {
        return (rec1.x1 <= rec2.x1 && rec2.x1 < rec1.x2)
                || (rec2.x1 < rec1.x1 && rec1.x1 < rec2.x2);
    }

    private boolean hasYIntersection(Rectangle rec1, Rectangle rec2) {
        return (rec1.y1 <= rec2.y1 && rec2.y1 < rec1.y2)
                || (rec2.y1 < rec1.y1 && rec1.y1 < rec2.y2);
    }

    private static class Rectangle {
        private final int x1, x2, y1, y2;
        Rectangle(int[] points) {
            this.x1 = points[0];
            this.y1 = points[1];
            this.x2 = points[2];
            this.y2 = points[3];
        }
    }
}
