import java.util.Scanner;

public class OnlineReservationSystem {
    // Variables to store user credentials
    private static String registeredUsername = "";
    private static String registeredPassword = "";

    // Variables to store reservation details
    private static int pnrNumber = 0;
    private static String reservedTrain = "";
    private static String reservedDate = "";
    private static String reservedFrom = "";
    private static String reservedTo = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Reservation System");

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    register(scanner);
                    break;
                case 2:
                    if (registeredUsername.isEmpty()) {
                        System.out.println("Please register first.");
                    } else {
                        if (login(scanner)) {
                            userMenu(scanner);
                        } else {
                            System.out.println("Login failed.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);  // Terminates the program
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void register(Scanner scanner) {
        System.out.println("\nUser Registration");
        System.out.print("Enter a username: ");
        registeredUsername = scanner.next();
        System.out.print("Enter a password: ");
        registeredPassword = scanner.next();
        System.out.println("Registration successful!");
    }

    private static boolean login(Scanner scanner) {
        System.out.println("\nUser Login");
        System.out.print("Enter username: ");
        String inputUsername = scanner.next();
        System.out.print("Enter password: ");
        String inputPassword = scanner.next();

        if (registeredUsername.equals(inputUsername) && registeredPassword.equals(inputPassword)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    private static void userMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n1. Make a Reservation");
            System.out.println("2. Cancel a Reservation");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    makeReservation(scanner);
                    break;
                case 2:
                    cancelReservation(scanner);
                    break;
                case 3:
                    System.out.println("Logged out successfully.");
                    return;  // Returns to the main menu and ends the current loop
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.println("\nEnter Reservation Details:");

        System.out.print("Enter Train Name: ");
        reservedTrain = scanner.next();
        System.out.print("Enter Date of Journey (dd-mm-yyyy): ");
        reservedDate = scanner.next();
        System.out.print("Enter From (place): ");
        reservedFrom = scanner.next();
        System.out.print("Enter To (destination): ");
        reservedTo = scanner.next();

        pnrNumber = (int) (Math.random() * 10000); // Generate a random PNR number

        System.out.println("\nReservation successful!");
        System.out.println("PNR Number: " + pnrNumber);
        System.out.println("Train: " + reservedTrain);
        System.out.println("Date of Journey: " + reservedDate);
        System.out.println("From: " + reservedFrom);
        System.out.println("To: " + reservedTo);
    }

    private static void cancelReservation(Scanner scanner) {
        if (pnrNumber == 0) {
            System.out.println("\nNo reservation found to cancel.");
            return;
        }

        System.out.print("Enter PNR Number to cancel: ");
        int inputPnr = scanner.nextInt();

        if (inputPnr == pnrNumber) {
            System.out.println("\nReservation cancelled successfully.");
            // Reset reservation details
            pnrNumber = 0;
            reservedTrain = "";
            reservedDate = "";
            reservedFrom = "";
            reservedTo = "";
        } else {
            System.out.println("\nInvalid PNR Number. No reservation found.");
        }
    }
}
