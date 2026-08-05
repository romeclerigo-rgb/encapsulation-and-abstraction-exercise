public class Van extends Vehicle {

    private int cargoCapacity;

    public Van(String plate, String model, double rate, int cargoCapacity) {
        super(plate, model, rate);
        this.cargoCapacity = cargoCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRate() * days) + 500;
    }

    @Override
    public String getVehicleType() {
        return "Van";
    }
}