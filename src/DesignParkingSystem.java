public class DesignParkingSystem {
    class ParkingSystem {
        private final int[] carSpots = new int[3];

        public ParkingSystem(int big, int medium, int small) {
            this.carSpots[0] = big;
            this.carSpots[1] = medium;
            this.carSpots[2] = small;
        }

        public boolean addCar(int carType) {
            if (carSpots[carType - 1] > 0) {
                carSpots[carType - 1]--;
                return true;
            }
            return false;
        }
    }
}
