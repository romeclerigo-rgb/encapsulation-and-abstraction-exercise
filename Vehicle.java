public abstract class Vehicle {
    
    private String plateNumber;
    private String model;
    private double baseRate;
    private boolean available;

    public Vehicle(String plateNumber, String model, double baseRate) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.baseRate = baseRate;
        this.available = true;
    }

  
    public String getPlateNumber() {
        return plateNumber;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public boolean isAvailable() {
        return available;
    }

   
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateRentalCost(int days);

    public abstract String getVehicleType();
}