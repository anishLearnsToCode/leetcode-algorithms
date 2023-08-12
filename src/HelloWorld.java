import java.util.*;

public class HelloWorld {
    public static void main(String[] args) {
        final List<String> words = new ArrayList<>();
        words.add("apple.ball.cat");
        words.add("apple.ball.cat.dog");

        final String word = "apple.ball.cat.dog";

        System.out.println(Arrays.toString(word.split("/.")));
    }
}
