public class DetermineColorOfChessboardSquare {
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0) - 'a') + (coordinates.charAt(1) - '1')) % 2 == 1;
    }
}
