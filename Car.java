public class Car extends Vehicle {

    private int seats;

    public Car(String plate, String model, double rate, int seats) {
        super(plate, model, rate);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRate() * days;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }
}