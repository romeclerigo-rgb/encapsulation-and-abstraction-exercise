public class Motorcycle extends Vehicle {

    private int cc;

    public Motorcycle(String plate, String model, double rate, int cc) {
        super(plate, model, rate);
        this.cc = cc;
    }

    public int getCC() {
        return cc;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRate() * days;
    }

    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }
}