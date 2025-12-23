package hotel.ui;

import hotel.model.Customer;
import hotel.model.Room;
import hotel.model.RoomType;
import hotel.resource.AdminResource;

import java.util.Scanner;

public class AdminMenu {

    private final AdminResource adminResource = new AdminResource();

    public void start() {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nAdmin Menu");
            System.out.println("---------------------------------------");
            System.out.println("1. See all Customers");
            System.out.println("2. See all Rooms");
            System.out.println("3. See all Reservations");
            System.out.println("4. Add a Room");
            System.out.println("5. Add Test Data");
            System.out.println("6. Back to Main Menu");
            System.out.println("---------------------------------------");
            System.out.print("Please select a number for the menu option: ");

            String input = scanner.nextLine();

            switch (input) {

                case "1":
                    adminResource.getAllCustomers()
                            .forEach(System.out::println);
                    break;

                case "2":
                    adminResource.getAllRooms()
                            .forEach(System.out::println);
                    break;

                case "3":
                    adminResource.getAllReservations()
                            .forEach(System.out::println);
                    break;

                case "4":
                    addRoom(scanner);
                    break;

                case "5":
                    addTestData();
                    System.out.println("Test data added successfully.");
                    break;

                case "6":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addRoom(Scanner scanner) {

        boolean addMore = true;

        while (addMore) {
            try {
                System.out.print("Enter Room Number: ");
                String roomNumber = scanner.nextLine();

                Double price = null;
                while (price == null) {
                    try {
                        System.out.print("Enter Price per Night: ");
                        price = Double.parseDouble(scanner.nextLine());
                        if (price < 0) {
                            System.out.println("Price cannot be negative.");
                            price = null;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid number. Please enter a valid price.");
                    }
                }

                System.out.println("Select Room Type:");
                System.out.println("1. SINGLE");
                System.out.println("2. DOUBLE");
                System.out.print("Enter choice (1 or 2): ");

                String typeChoice = scanner.nextLine();
                RoomType roomType;

                if (typeChoice.equals("1")) {
                    roomType = RoomType.SINGLE;
                } else if (typeChoice.equals("2")) {
                    roomType = RoomType.DOUBLE;
                } else {
                    System.out.println("Invalid room type selection.");
                    continue;
                }

                Room room = new Room(roomNumber, price, roomType);
                adminResource.addRoom(room);

                System.out.println("Room added successfully!");

                boolean validChoice = false;

                while (!validChoice) {
                    System.out.print("Do you want to add another room? (y/n): ");
                    String choice = scanner.nextLine();

                    if (choice.equalsIgnoreCase("y")) {
                        validChoice = true;
                        addMore = true;
                    } else if (choice.equalsIgnoreCase("n")) {
                        validChoice = true;
                        addMore = false;
                    } else {
                        System.out.println("Invalid input. Please enter 'y' or 'n'.");
                    }
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private void addTestData() {

        adminResource.addRoom(new Room("100", 100.0, RoomType.SINGLE));
        adminResource.addRoom(new Room("101", 150.0, RoomType.SINGLE));
        adminResource.addRoom(new Room("102", 250.0, RoomType.DOUBLE));
        adminResource.addRoom(new Room("200", 500.0, RoomType.DOUBLE));
    }
}