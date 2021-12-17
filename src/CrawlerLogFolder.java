public class CrawlerLogFolder {
    private static final String GO_UP = "../";
    private static final String REMAIN_WHERE_YOU_ARE = "./";

    public int minOperations(String[] logs) {
        int level = 0;
        for (String log : logs) {
            if (GO_UP.equals(log)) {
                level = Math.max(0, level - 1);
            } else if (!REMAIN_WHERE_YOU_ARE.equals(log)){
                level++;
            }
        }
        return level;
    }
}
