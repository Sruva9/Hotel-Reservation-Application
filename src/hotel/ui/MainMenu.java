package hotel.ui;

import java.util.Scanner;
import hotel.model.Room;
import hotel.resource.HotelResource;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import hotel.ui.AdminMenu;
import hotel.model.Customer;

public class MainMenu {

    private final HotelResource hotelResource = new HotelResource();

    public void start() {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n WELCOME TO THE HOTEL RESERVATION APPLICATION");
            System.out.println("---------------------------------------");
            System.out.println("1. Find and reserve a room");
            System.out.println("2. See my reservations");
            System.out.println("3. Create an Account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            System.out.println("---------------------------------------");
            System.out.print("Please select a number from the menu option: ");

            String input;
            while (true) {
                input = scanner.nextLine();
                if (input.matches("[1-5]")) {
                    break;
                }
                System.out.print("Invalid choice. Please select a number from the menu option.");
            }

            switch (input) {
                case "1":

                    try {
                        Date checkInDate = null;
                        Date checkOutDate = null;

                        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                        formatter.setLenient(false);

                        while (checkInDate == null) {
                            try {
                                System.out.print("Enter Check-In Date (MM/dd/yyyy): ");
                                checkInDate = formatter.parse(scanner.nextLine());
                            } catch (Exception e) {
                                System.out.println("Invalid date format. Please try again.");
                            }
                        }

                        while (checkOutDate == null) {
                            try {
                                System.out.print("Enter Check-Out Date (MM/dd/yyyy): ");
                                checkOutDate = formatter.parse(scanner.nextLine());
                            } catch (Exception e) {
                                System.out.println("Invalid date format. Please try again.");
                            }
                        }

                        Collection<Room> availableRooms =
                                hotelResource.findARoom(checkInDate, checkOutDate);

                        if (availableRooms.isEmpty()) {
                            System.out.println("No rooms available for given dates.");
                            break;
                        }

                        System.out.println("\nAvailable Rooms:");
                        for (Room room : availableRooms) {
                            System.out.println(room);
                        }

                        System.out.print("\nDo you want to book a room? (y/n): ");
                        String bookChoice = scanner.nextLine();

                        if (!bookChoice.equalsIgnoreCase("y")) {
                            System.out.println("Returning to main menu...");
                            break;
                        }

                        System.out.print("Do you have an account with us? (y/n): ");
                        String accountChoice = scanner.nextLine();

                        if (!accountChoice.equalsIgnoreCase("y")) {
                            System.out.println("Please create an account first from the main menu.");
                            break;
                        }

                        System.out.print("Enter your email (example: name@domain.com): ");
                        String email = scanner.nextLine();

                        Customer customer = hotelResource.getCustomer(email);
                        if (customer == null) {
                            System.out.println("No account found for this email.");
                            break;
                        }

                        System.out.print("Enter the Room Number you want to reserve: ");
                        String roomNumber = scanner.nextLine();

                        Room selectedRoom = null;
                        for (Room room : availableRooms) {
                            if (room.getRoomNumber().equals(roomNumber)) {
                                selectedRoom = room;
                                break;
                            }
                        }

                        if (selectedRoom == null) {
                            System.out.println("Invalid room number.");
                            break;
                        }

                        hotelResource.bookARoom(customer, selectedRoom, checkInDate, checkOutDate);
                        SimpleDateFormat outputFormatter =
                                new SimpleDateFormat("EEE MMM dd yyyy");

                        System.out.println("\n RESERVATION CONFIRMED ");
                        System.out.println("----------------------------------");
                        System.out.println("Customer Name : " + customer);
                        System.out.println("Room Number   : " + selectedRoom.getRoomNumber());
                        System.out.println("Room Type     : " + selectedRoom.getRoomType());
                        System.out.println("Price / Night : " +
                                (selectedRoom.getPrice() == 0 ? "Free" : "$" + selectedRoom.getPrice()));
                        System.out.println("Check-In Date : " + outputFormatter.format(checkInDate));
                        System.out.println("Check-Out Date: " + outputFormatter.format(checkOutDate));
                        System.out.println("----------------------------------");

                    } catch (Exception e) {
                        System.out.println("Something went wrong. Please try again.");
                    }

                    break;

                case "2":
                    try {
                        System.out.print("Enter your email: ");
                        String email = scanner.nextLine();

                        Customer customer = hotelResource.getCustomer(email);
                        if (customer == null) {
                            System.out.println("No account found for this email.");
                            break;
                        }

                        Collection<?> reservations =
                                hotelResource.getCustomerReservations(customer);

                        if (reservations.isEmpty()) {
                            System.out.println("You have no reservations.");
                        } else {
                            System.out.println("\nYour Reservations:");
                            for (Object r : reservations) {
                                System.out.println(r);
                            }
                        }

                    } catch (Exception e) {
                        System.out.println("Unable to fetch reservations.");
                    }
                    break;

                case "3":
                    try {
                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Enter First Name: ");
                        String firstName = scanner.nextLine();

                        System.out.print("Enter Last Name: ");
                        String lastName = scanner.nextLine();

                        hotelResource.createCustomer(email, firstName, lastName);
                        System.out.println("Account created successfully!");

                    } catch (Exception e) {
                        System.out.println("Unable to create account. Please check details.");
                    }
                    break;

                case "4":
                    AdminMenu adminMenu = new AdminMenu();
                    adminMenu.start();
                    break;

                case "5":
                    System.out.println("Exiting application. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Please select a number from the menu option.");
            }
        }
    }
}