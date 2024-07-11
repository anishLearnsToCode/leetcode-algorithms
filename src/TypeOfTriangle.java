// https://leetcode.com/problems/type-of-triangle
// T: O(1)
// S: O(1)

public class TypeOfTriangle {
    public String triangleType(int[] sides) {
        if (!isValidTriangle(sides)) {
            return "none";
        }
        if (sides[0] == sides[1] && sides[1] == sides[2]) {
            return "equilateral";
        }
        if (sides[0] == sides[1] || sides[0] == sides[2] || sides[1] == sides[2]) {
            return "isosceles";
        }
        return "scalene";
    }

    private static boolean isValidTriangle(int[] sides) {
        return sides[0] + sides[1] > sides[2] && sides[0] + sides[2] > sides[1] && sides[1] + sides[2] > sides[0];
    }
}
