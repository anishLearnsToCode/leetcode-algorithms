public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int vertical = 0, horizontal = 0;
        for (int index = 0 ; index < moves.length() ; index++) {
            switch (moves.charAt(index)) {
                case 'U' -> vertical++;
                case 'R' -> horizontal++;
                case 'D' -> vertical--;
                case 'L' -> horizontal--;
            }
        }
        return vertical == 0 && horizontal == 0;
    }
}
