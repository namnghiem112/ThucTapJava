import entity.AirportManager;
import entity.FixedWing;
import entity.Helicopter;

import java.util.Scanner;

public class Main {

    private static AirportManager airportManager = new AirportManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    createAirport();
                    break;
                case 2:
                    addFixedWingAirplane();
                    break;
                case 3:
                    removeFixedWingAirplane();
                    break;
                case 4:
                    addHelicopter();
                    break;
                case 5:
                    removeHelicopter();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n==== Menu ====");
        System.out.println("1. Create Airport");
        System.out.println("2. Add Fixed Wing Airplane to Airport");
        System.out.println("3. Remove Fixed Wing Airplane from Airport");
        System.out.println("4. Add Helicopter to Airport");
        System.out.println("5. Remove Helicopter from Airport");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createAirport() {
        System.out.print("Enter airport ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter airport name: ");
        String name = scanner.nextLine();
        System.out.print("Enter runway size: ");
        int runwaySize = scanner.nextInt();
        System.out.print("Enter max fixed wing parking places: ");
        int maxFixedwingParkingPlace = scanner.nextInt();
        System.out.print("Enter max helicopter parking places: ");
        int maxRotatedWingParkingPlace = scanner.nextInt();

        airportManager.createAirport(id, name, runwaySize, maxFixedwingParkingPlace, maxRotatedWingParkingPlace);
    }

    private static void addFixedWingAirplane() {
        System.out.print("Enter airport ID: ");
        String airportId = scanner.nextLine();
        System.out.print("Enter airplane ID: ");
        String airplaneId = scanner.nextLine();
        System.out.print("Enter airplane model: ");
        String model = scanner.nextLine();
        System.out.print("Enter airplane type (CAG, LGR, PRV): ");
        String type = scanner.nextLine();
        System.out.print("Enter airplane cruise speed: ");
        double cruiseSpeed = scanner.nextDouble();
        System.out.print("Enter airplane empty weight: ");
        double emptyWeight = scanner.nextDouble();
        System.out.print("Enter airplane max takeoff weight: ");
        double maxTakeoffWeight = scanner.nextDouble();
        System.out.print("Enter airplane min needed runway size: ");
        double minNeededRunwaySize = scanner.nextDouble();

        FixedWing airplane = new FixedWing(airplaneId, model, type, cruiseSpeed, emptyWeight, maxTakeoffWeight, minNeededRunwaySize);
        airportManager.addFixedWingAirplaneToAirport(airportId, airplane);
    }

    private static void removeFixedWingAirplane() {
        System.out.print("Enter airport ID: ");
        String airportId = scanner.nextLine();
        System.out.print("Enter airplane ID: ");
        String airplaneId = scanner.nextLine();

        airportManager.removeFixedWingAirplaneFromAirport(airportId, airplaneId);
    }

    private static void addHelicopter() {
        System.out.print("Enter airport ID: ");
        String airportId = scanner.nextLine();
        System.out.print("Enter helicopter ID: ");
        String helicopterId = scanner.nextLine();
        System.out.print("Enter helicopter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter helicopter cruise speed: ");
        double cruiseSpeed = scanner.nextDouble();
        System.out.print("Enter helicopter empty weight: ");
        double emptyWeight = scanner.nextDouble();
        System.out.print("Enter helicopter max takeoff weight: ");
        double maxTakeoffWeight = scanner.nextDouble();
        System.out.print("Enter helicopter range: ");
        double range = scanner.nextDouble();

        Helicopter helicopter = new Helicopter(helicopterId, model, cruiseSpeed, emptyWeight, maxTakeoffWeight, range);
        airportManager.addHelicopterToAirport(airportId, helicopter);
    }

    private static void removeHelicopter() {
        System.out.print("Enter airport ID: ");
        String airportId = scanner.nextLine();
        System.out.print("Enter helicopter ID: ");
        String helicopterId = scanner.nextLine();

        airportManager.removeHelicopterFromAirport(airportId, helicopterId);
    }
}
