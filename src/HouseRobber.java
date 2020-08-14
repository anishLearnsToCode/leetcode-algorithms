public class HouseRobber {
    public static int rob(int[] array) {
        if (array.length == 0) return 0;

        int[] memory = new int[array.length + 1];
        memory[1] = array[0];
        for (int index = 1 ; index < array.length ; index++) {
            memory[index + 1] = Math.max(memory[index], memory[index - 1] + array[index]);
        }
        return memory[memory.length - 1];
    }
}
