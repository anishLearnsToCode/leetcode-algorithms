public class HelloWorld {
    private final int[] memory;

    public HelloWorld(int[] array, int m) {
        this.memory = new int[m + 1];
        for (int element : array) {
            memory[element]++;
        }
        for (int i = 1 ; i < memory.length ; i++) {
            memory[i] += memory[i - 1];
        }
    }

    public int query(int a, int b) {
        if (b > memory.length - 1) {
            b = memory.length - 1;
        }

        if (a <= 0) {
            a = 1;
        } else if (a > memory.length - 1) {
            a = memory.length;
        }

        return this.memory[b] - this.memory[a - 1];
    }

    public static void main(String[] args) {

        System.out.println(Math.round(10.5));
    }
}
