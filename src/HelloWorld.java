import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HelloWorld {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int maxLength = 1;
        final Set<Character> slidingWindow = new HashSet<>() {{
            add(s.charAt(0));
        }};

        for (int left = 0, right = 1, currentLength = 1 ; right < s.length() ; ) {
            if (slidingWindow.contains(s.charAt(right))) {
                slidingWindow.remove(s.charAt(left));
                left++;
                currentLength--;
            } else {
                slidingWindow.add(s.charAt(right));
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
                right++;
            }
        }


        return maxLength;
    }
}
