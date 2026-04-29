import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. Search Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View All Bookings");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> hotel.searchRooms();
                case 2 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Room Number: ");
                    int room = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Date: ");
                    String date = sc.nextLine();
                    hotel.bookRoom(name, room, date);
                }
                case 3 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    hotel.cancelBooking(name);
                }
                case 4 -> hotel.viewBookings();
                case 5 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}