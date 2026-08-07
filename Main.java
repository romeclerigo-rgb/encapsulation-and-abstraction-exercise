import java.util.*;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Validation validation = new Validation();

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        boolean loop = true;

        while (loop) {

            System.out.println("=======================================");
            System.out.println("   VEHICLE RENTAL MANAGEMENT SYSTEM");
            System.out.println("=======================================");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. Rent a Vehicle");
            System.out.println("4. Return a Vehicle");
            System.out.println("5. Exit");

            int choice = validation.getMenuChoice(sc);
            switch (choice) {

    case 1:

        int vehicleChoice = validation.getVehicleChoice(sc);

        String plate = validation.getPlateNumber(sc, vehicles);
        String model = validation.getModel(sc);
        double rate = validation.getPositiveDouble(sc, "Enter Base Rate Per Day: ");

        switch (vehicleChoice) {

            case 1:
                int seats = validation.getCarSeats(sc);
                vehicles.add(new Car(plate, model, rate, seats));
                break;

            case 2:
                int engineDisplacement = validation.getEngineCC(sc);
                vehicles.add(new Motorcycle(plate, model, rate, engineDisplacement));
                break;

            case 3:
                int cargoCapacity = validation.getCargoCapacity(sc);
                vehicles.add(new Van(plate, model, rate, cargoCapacity));
                break;
        }

        System.out.println("\nVehicle added successfully!");
        break;

    case 2:

        if (vehicles.isEmpty()) {
            System.out.println("\nNo vehicles found.");
            break;
        }

        System.out.println("\n======================================================================================");
        System.out.printf("%-12s %-15s %-20s %-15s %-12s%n",
                "Plate No.", "Type", "Model", "Base Rate", "Status");
        System.out.println("======================================================================================");

        for (Vehicle vehicle : vehicles) {

            String status;

            if (vehicle.isAvailable()) {
                status = "Available";
            } else {
                status = "Rented";
            }

            System.out.printf("%-12s %-15s %-20s PhP%,-14.2f %-12s%n",
                vehicle.getPlateNumber(),
                vehicle.getVehicleType(),
                vehicle.getModel(),
                vehicle.getBaseRate(),
                    status);
        }

        break;

    case 3:

        if (vehicles.isEmpty()) {
            System.out.println("\nNo vehicles available.");
            break;
        }

        System.out.print("Enter Plate Number: ");
        String rentPlate = sc.nextLine().trim().toUpperCase();

        boolean rentFound = false;

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getPlateNumber().equalsIgnoreCase(rentPlate)) {

                rentFound = true;

                if (!vehicle.isAvailable()) {
                    System.out.println("Vehicle not available!");
                    break;
                }

                int days = validation.getPositiveInteger(sc, "Enter Number of Rental Days: ");
                
                double subtotal = vehicle.getBaseRate() * days;
                double total = vehicle.calculateRentalCost(days);
                double driverFee = total - subtotal;

                System.out.println("\n========== RENTAL SUMMARY ==========");
                System.out.println("Plate Number : " + vehicle.getPlateNumber());
                System.out.println("Vehicle Type : " + vehicle.getVehicleType());
                System.out.println("Model        : " + vehicle.getModel());

                System.out.printf("Base Rate    : PhP%,.2f%n", vehicle.getBaseRate());
                System.out.println("Rental Days  : " + days);

                System.out.println("------------------------------------");

                System.out.printf("Rental Cost  : PhP%,.2f%n", subtotal);

                if (driverFee > 0) {
                    System.out.printf("Driver Fee   : PhP%,.2f%n", driverFee);
                }

                System.out.println("------------------------------------");
                System.out.printf("TOTAL        : PhP%,.2f%n", total);
                System.out.println("====================================");

                char confirm = validation.getConfirmation(sc);

                if (confirm == 'Y') {

                    vehicle.setAvailable(false);
                    System.out.println("Vehicle rented successfully!");

                } else {

                    System.out.println("Rental cancelled.");

                }
                break;
            }
        }

        if (!rentFound) {
            System.out.println("Vehicle not found!");
        }

        break;

    case 4:

        if (vehicles.isEmpty()) {
            System.out.println("\nNo vehicles found.");
            break;
        }

        System.out.print("Enter Plate Number: ");
        String returnPlate = sc.nextLine().trim().toUpperCase();

        boolean returnFound = false;

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getPlateNumber().equalsIgnoreCase(returnPlate)) {

                returnFound = true;

                if (vehicle.isAvailable()) {
                    System.out.println("Vehicle was not rented.");
                } else {
                    vehicle.setAvailable(true);
                    System.out.println("Vehicle returned successfully!");
                }

                break;
            }
        }

        if (!returnFound) {
            System.out.println("Vehicle not found!");
        }

        break;

    case 5:

        loop = false;
        System.out.println("Thank you for using the Vehicle Rental Management System!");
        break;
}

            System.out.println();
        }

        sc.close();
    }

}
            