import java.util.ArrayList;
import java.util.Scanner;

public class Validation {


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

   
    public String getPlateNumber(Scanner sc, ArrayList<Vehicle> vehicles) {

        boolean valid = false;
        String plate = "";

        while (!valid) {

            System.out.print("Enter Plate Number: ");
            plate = sc.nextLine().trim().toUpperCase();

            if (plate.isEmpty()) {
                System.out.println("Plate Number cannot be empty.");
            }
            else if (!plate.matches("(?=.*\\d)(?=.*[A-Z])[A-Z0-9]{4,10}")) {
                System.out.println("Plate Number must be 4 to 10 characters and contain at least 1 number and 1 letter.");
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

    public boolean isDuplicatePlate(ArrayList<Vehicle> vehicles, String plate) {

        for (Vehicle vehicle : vehicles) {

            if (vehicle.getPlateNumber().equalsIgnoreCase(plate)) {
                return true;
            }

        }

        return false;
    }

    public char getConfirmation(Scanner sc) {

        boolean valid = false;
        char answer = ' ';

        while (!valid) {

            System.out.print("Confirm Rental? (Y/N): ");
            String input = sc.nextLine().trim().toUpperCase();

            if (input.matches("[YN]")) {
                answer = input.charAt(0);
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }

        return answer;
    }
    
    public int getCarSeats(Scanner sc) {

            boolean valid = false;
            int seats = 0;

            while (!valid) {

                System.out.print("Enter Number of Seats (1-8): ");
                String input = sc.nextLine();

                if (input.matches("[1-8]")) {
                    seats = Integer.parseInt(input);
                    valid = true;
                } else {
                    System.out.println("A car must have 1 to 8 seats.");
                }
            }

            return seats;
        }
    public int getEngineCC(Scanner sc) {

    boolean valid = false;
    int cc = 0;

    while (!valid) {

        System.out.print("Enter Engine Displacement (50-2000 cc): ");
        String input = sc.nextLine();

        if (input.matches("\\d+")) {

            cc = Integer.parseInt(input);

            if (cc >= 50 && cc <= 2000) {
                valid = true;
            } else {
                System.out.println("Engine displacement must be between 50 and 2000 cc.");
            }

        } else {
            System.out.println("Invalid input. Please enter numbers only.");
            }
        }

        return cc;
    }
        public int getCargoCapacity(Scanner sc) {

        boolean valid = false;
        int capacity = 0;

        while (!valid) {

            System.out.print("Enter Cargo Capacity (1-5000 kg): ");
            String input = sc.nextLine();

            if (input.matches("\\d+")) {

                capacity = Integer.parseInt(input);

                if (capacity >= 1 && capacity <= 5000) {
                    valid = true;
                } else {
                    System.out.println("Cargo capacity must be between 1 and 5000 kg.");
                }

            } else {
                System.out.println("Invalid input. Please enter numbers only.");
            }
        }

            return capacity;
        }

}