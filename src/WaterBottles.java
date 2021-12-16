public class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink = numBottles;
        while (numBottles >= numExchange) {
            drink += numBottles / numExchange;
            numBottles = numBottles  % numExchange + numBottles / numExchange;
        }
        return drink;
    }
}
