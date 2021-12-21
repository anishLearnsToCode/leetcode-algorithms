import java.util.List;

public class CountItemsMatchingARule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        return countMatches(items, getRuleIndex(ruleKey), ruleValue);
    }

    private int countMatches(List<List<String>> items, int ruleIndex, String ruleValue) {
        int matches = 0;
        for (List<String> item : items) {
            if (item.get(ruleIndex).equals(ruleValue)) matches++;
        }
        return matches;
    }

    private int getRuleIndex(String key) {
        return switch (key) {
            case "type" -> 0;
            case "color" -> 1;
            case "name" -> 2;
            default -> -1;
        };
    }
}
