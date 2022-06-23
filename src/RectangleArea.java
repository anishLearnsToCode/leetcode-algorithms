// https://leetcode.com/problems/rectangle-area
// T: O(1)
// S: O(1)

public class RectangleArea {
    private record Point(int x, int y) {}

    private static class Rectangle {
        public final int xl;
        public final int xr;
        public final int yb;
        public final int yt;
        public final int area;

        Rectangle(Point lowerLeft, Point upperRight) {
            xl = lowerLeft.x;
            xr = upperRight.x;
            yb = lowerLeft.y;
            yt = upperRight.y;
            area = (upperRight.x - lowerLeft.x) * (upperRight.y - lowerLeft.y);
        }

        public static Rectangle from(int x1, int y1, int x2, int y2) {
            final Point a1 = new Point(x1, y1);
            final Point a2 = new Point(x2, y2);
            return new Rectangle(a1, a2);
        }

        public Rectangle intersection(Rectangle other) {
            final int intersectionXl = Math.max(xl, other.xl);
            final int intersectionXr = Math.max(intersectionXl, Math.min(xr, other.xr));
            final int intersectionYb = Math.max(yb, other.yb);
            final int intersectionYt = Math.max(intersectionYb, Math.min(yt, other.yt));

            if (intersectionXl > intersectionXr || intersectionYb > intersectionYt) {
                return null;
            }

            return Rectangle.from(intersectionXl, intersectionYb, intersectionXr, intersectionYt);
        }
    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        final Rectangle rectangle1 = Rectangle.from(ax1, ay1, ax2, ay2);
        final Rectangle rectangle2 = Rectangle.from(bx1, by1, bx2, by2);
        final Rectangle intersection = rectangle1.intersection(rectangle2);
        return rectangle1.area + rectangle2.area - (intersection == null ? 0 : intersection.area);
    }
}
