class BrowserHistory {
    private List<String> history;
    private int ptr;

    public BrowserHistory(String homepage) {
        this.history = new ArrayList<>();
        this.history.add(homepage);
        this.ptr = 0;
    }

    public void visit(String url) {
        this.ptr++;
        this.history = this.history.subList(0, this.ptr);
        this.history.add(url);
    }

    public String back(int steps) {
        this.ptr = Math.max(0, this.ptr - steps);
        return this.history.get(this.ptr);
    }

    public String forward(int steps) {
        this.ptr = Math.min(this.history.size() - 1, this.ptr + steps);
        return this.history.get(this.ptr);
    }
}
