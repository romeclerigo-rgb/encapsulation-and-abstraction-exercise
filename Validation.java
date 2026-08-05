import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    // ==========================
    // Main Menu Choice
    // ==========================
    public int getMenuChoice(Scanner sc) {

        boolean valid = false;
        int choice = 0;

        while (!valid) {

            System.out.print("Enter your choice: ");
            String input = sc.nextLine();

            if (input.matches("[1-5]")) {
                choice = Integer.parseInt(input);
                valid = true;
            } else {
                System.out.println("Invalid input! Please enter a number from 1 to 5 only.");
            }
        }

        return choice;
    }

    // ==========================
    // Vehicle Type Choice
    // ==========================
    public int getVehicleChoice(Scanner sc) {

        boolean valid = false;
        int choice = 0;

        while (!valid) {

            System.out.println("\nVehicle Types");
            System.out.println("1. Car");
            System.out.println("2. Motorcycle");
            System.out.println("3. Van");

            System.out.print("Choose vehicle type: ");
            String input = sc.nextLine();

            if (input.matches("[1-3]")) {
                choice = Integer.parseInt(input);
                valid = true;
            } else {
                System.out.println("Invalid vehicle type.");
            }
        }

        return choice;
    }

    // ==========================
    // Plate Number
    // ==========================
    public String getPlateNumber(Scanner sc, ArrayList<Vehicle> vehicles) {

        boolean valid = false;
        String plate = "";

        while (!valid) {

            System.out.print("Enter Plate Number: ");
            plate = sc.nextLine().trim().toUpperCase();

            if (plate.isEmpty()) {
                System.out.println("Plate Number cannot be empty.");
            }
            else if (!plate.matches("[A-Z0-9]+")) {
                System.out.println("Plate Number must contain letters and numbers only.");
            }
            else if (isDuplicatePlate(vehicles, plate)) {
                System.out.println("Plate Number already exists.");
            }
            else {
                valid = true;
            }
        }

        return plate;
    }

    // ==========================
    // Model
    // ==========================
    public String getModel(Scanner sc) {

        boolean valid = false;
        String model = "";

        while (!valid) {

            System.out.print("Enter Model: ");
            model = sc.nextLine().trim();

            if (model.isEmpty()) {
                System.out.println("Model cannot be empty.");
            }
            else {
                valid = true;
            }
        }

        return model;
    }

    // ==========================
    // Positive Integer
    // ==========================
    public int getPositiveInteger(Scanner sc, String message) {

        boolean valid = false;
        int number = 0;

        while (!valid) {

            System.out.print(message);
            String input = sc.nextLine();

            if (input.matches("[1-9]\\d*")) {
                number = Integer.parseInt(input);
                valid = true;
            }
            else {
                System.out.println("Please enter a positive whole number.");
            }
        }

        return number;
    }

    // ==========================
    // Positive Double
    // ==========================
    public double getPositiveDouble(Scanner sc, String message) {

        boolean valid = false;
        double number = 0;

        while (!valid) {

            System.out.print(message);
            String input = sc.nextLine();

            if (input.matches("\\d+(\\.\\d+)?")) {

                number = Double.parseDouble(input);

                if (number > 0) {
                    valid = true;
                }
                else {
                    System.out.println("Value must be greater than zero.");
                }

            }
            else {
                System.out.println("Invalid decimal number.");
            }
        }

        return number;
    }

    // ==========================
    // Duplicate Plate Checker
    // ==========================
    public boolean isDuplicatePlate(ArrayList<Vehicle> vehicles, String plate) {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getPlateNumber().equalsIgnoreCase(plate)) {
                return true;
            }

        }

        return false;
    }
    public char getConfirmation(Scanner sc) {

    while (true) {

        System.out.print("Confirm Rental? (Y/N): ");

        String input = sc.nextLine().trim().toUpperCase();

        if (input.equals("Y") || input.equals("N")) {
            return input.charAt(0);
        }

        System.out.println("Invalid input.");
    }
}

}