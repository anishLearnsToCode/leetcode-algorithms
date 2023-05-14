// https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet
// T: O(1)
// S: O(1)

import java.util.ArrayList;
import java.util.List;

public class CellsInARangeOnAnExcelSheet {
    public List<String> cellsInRange(String s) {
        final char column1 = s.charAt(0);
        final char column2 = s.charAt(3);
        final int row1 = s.charAt(1) - '0';
        final int row2 = s.charAt(4) - '0';

        final List<String> result = new ArrayList<>();

        for (char column = column1 ; column <= column2 ; column++) {
            for (int row = row1 ; row <= row2 ; row++) {
                result.add((column + "") + row);
            }
        }

        return result;
    }
}
