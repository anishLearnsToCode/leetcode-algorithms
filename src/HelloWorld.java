import java.util.Scanner;

public class HelloWorld {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static void spiralOrder(int[][] matrix){
        final int rows = matrix.length, columns = matrix[0].length, elements = rows * columns;
        for (int i = 0, top = 0, bottom = rows, left = 0, right = columns ; ; ) {
            for (int row = top, column = left ; column < right ; column++, i++) {
                System.out.print(matrix[row][column]);
            }
            top++;
            if (i == elements) break;
            for (int row = top, column = right - 1 ; row < bottom ; row++, i++) {
                System.out.print(matrix[row][column]);
            }
            right--;
            if (i == elements) break;
            for (int row = bottom - 1, column = right - 1 ; column >= left ; column--, i++) {
                System.out.print(matrix[row][column]);
            }
            bottom--;
            if (i == elements) break;
            for (int row = bottom - 1, column = left ; row >= top ; row--, i++) {
                System.out.print(matrix[row][column]);
            }
            left++;
            if (i == elements) break;
        }
    }

    private static int intInput(final String string) {
        System.out.print(string);
        final int i = SCANNER.nextInt();
        return i;
    }

    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        final int rows = intInput("Enter row size: ");
        final int columns = intInput("Enter column size: ");
        final int[][] matrix = new int[rows][columns];

        System.out.println("Enter array elements:");

        for (int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < columns ; j++) {
                matrix[i][j] = SCANNER.nextInt();
            }
        }

        spiralOrder(matrix);

        System.out.println("\n\nOriginal matrix");
        print(matrix);
    }
}