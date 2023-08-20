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
        HelloWorld helloWorld = new HelloWorld(new int[] {1, 2, 3, 4, 5, 1, 2, 1, 2}, 5);
        System.out.println(helloWorld.query(0, 0));
        System.out.println(helloWorld.query(0, 1));
        System.out.println(helloWorld.query(0, 2));
        System.out.println(helloWorld.query(3, 3));
        System.out.println(helloWorld.query(20, 30));
        System.out.println(helloWorld.query(10, 15));
    }
}
