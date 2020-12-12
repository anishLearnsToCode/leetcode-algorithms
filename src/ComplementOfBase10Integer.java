import java.util.Scanner;

public class ComplementOfBase10Integer {
    public static int bitwiseComplement(int n) {
        int numberOfBits = (int) (Math.floor(Math.log(n) / Math.log(2))) + 1;
        return ((1 << numberOfBits) - 1) ^ n;
    }
}
