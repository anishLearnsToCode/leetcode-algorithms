public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strings) {
        final int columns = strings[0].length();
        int deletions = 0;
        for (int column = 0 ; column < columns ; column++) {
            if (!isSorted(strings, column)) deletions++;
        }
        return deletions;
    }

    private boolean isSorted(String[] strings, int column) {
        for (int row = 1 ; row < strings.length ; row++) {
            if (strings[row].charAt(column) < strings[row - 1].charAt(column)) return false;
        }
        return true;
    }
}
