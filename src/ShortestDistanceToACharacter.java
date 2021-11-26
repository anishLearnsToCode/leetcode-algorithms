public class ShortestDistanceToACharacter {
    public int[] shortestToChar(String string, char c) {
        int[] answer = new int[string.length()];
        for (int i = 0, l = Integer.MIN_VALUE ; i < string.length() ; i++) {
            if (string.charAt(i) == c) l = i;
            answer[i] = l == Integer.MIN_VALUE ? Integer.MAX_VALUE : i - l;
        }

        for (int i = string.length() - 1, r = Integer.MAX_VALUE ; i >= 0 ; i--) {
            if (string.charAt(i) == c) r = i;
            answer[i] = Math.min(answer[i], r - i);
        }

        return answer;
    }
}
