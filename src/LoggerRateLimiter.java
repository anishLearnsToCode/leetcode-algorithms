// https://leetcode.com/problems/logger-rate-limiter
// N: number of requests made to shouldPrint(), M: total number of different messages
// T: O(N)
// S: O(M)

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
}

class Logger {
    final Map<String, Integer> messageTimestamps = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestamps.containsKey(message)) {
            messageTimestamps.put(message, timestamp);
            return true;
        }

        if (messageTimestamps.get(message) + 10 > timestamp) {
            return false;
        }

        messageTimestamps.put(message, timestamp);
        return true;
    }
}