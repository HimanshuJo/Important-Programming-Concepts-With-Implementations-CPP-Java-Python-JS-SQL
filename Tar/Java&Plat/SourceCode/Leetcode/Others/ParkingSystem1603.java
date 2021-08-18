class ParkingSystem {

    private int[] isPossible;

    public ParkingSystem(int big, int medium, int small) {

        isPossible = new int[4];

        isPossible[1] = big;
        isPossible[2] = medium;
        isPossible[3] = small;

    }

    public boolean addCar(int carType) {

        return isPossible[carType] --> 0;

    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
