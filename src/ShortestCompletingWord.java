public class ShortestCompletingWord {
    private final int[] primes = {
            2,  3,  5,  7, 11, 13, 17, 19, 23, 29, 31, 37,  41,
            43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
    };

    public String shortestCompletingWord(String licensePlate, String[] words) {
        long licenseHash = getHash(licensePlate);
        int shortestCompletingWordLen = Integer.MAX_VALUE;
        int shortestWordIndex = -1;
        for (int index = 0 ; index < words.length ; index++) {
            if (words[index].length() < shortestCompletingWordLen && containsAllChars(words[index], licenseHash)) {
                shortestCompletingWordLen = words[index].length();
                shortestWordIndex = index;
            }
        }
        return words[shortestWordIndex];
    }

    private long getHash(String string) {
        long result = 1;
        for (char character : string.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(character)) {
                result *= primes[character - 'a'];
            }
        }
        return result;
    }

    private boolean containsAllChars(String word, long hash) {
        long result = 1;
        for (char character : word.toCharArray()){
            result = (result * primes[character - 'a']) % hash;
        }
        return result == 0;
    }
}
