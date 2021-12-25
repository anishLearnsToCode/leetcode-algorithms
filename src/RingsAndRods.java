// https://leetcode.com/problems/rings-and-rods
// T: O(|rings|)
// S: O(1)

public class RingsAndRods {
    public int countPoints(String rings) {
        final boolean[][] rods = new boolean[10][3];
        for (int i = 0 ; i < rings.length() ; i += 2) {
            rods[rings.charAt(i + 1) - '0'][toColorIndex(rings.charAt(i))] = true;
        }
        int points = 0;
        for (boolean[] rod : rods) {
            if (containsAllColors(rod)) {
                points++;
            }
        }
        return points;
    }

    private int toColorIndex(char color) {
        return switch (color) {
            case 'R' -> 0;
            case 'G' -> 1;
            case 'B' -> 2;
            default -> -1;
        };
    }

    private boolean containsAllColors(boolean[] rod) {
        return rod[0] && rod[1] && rod[2];
    }
}
