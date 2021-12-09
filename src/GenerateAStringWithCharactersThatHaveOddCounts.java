public class GenerateAStringWithCharactersThatHaveOddCounts {
    public String generateTheString(int n) {
        if ((n & 1) == 0) {
            return "a".repeat(n - 1) + "b";
        } return "a".repeat(n);
    }
}
