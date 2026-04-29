import java.sql.*;
import java.util.*;

public class Hotel {

    public void searchRooms() {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM rooms WHERE is_available = TRUE";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\nAvailable Rooms:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("room_number") + " | " +
                        rs.getString("category") + " | ₹" +
                        rs.getDouble("price"));
            }
        } catch (Exception e) {
            System.out.println("Search Error: " + e.getMessage());
        }
    }

    public boolean bookRoom(String name, int roomNumber, String date) {
        try (Connection conn = DBConnection.getConnection()) {

            // 1. Get room details
            String roomQuery = "SELECT * FROM rooms WHERE room_number = ? AND is_available = TRUE";
            PreparedStatement rstmt = conn.prepareStatement(roomQuery);
            rstmt.setInt(1, roomNumber);
            ResultSet rs = rstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Room not available!");
                return false;
            }

            double price = rs.getDouble("price");

            // 2. Payment simulation
            boolean paid = Payment.makePayment(name, price);

            // 3. Insert reservation
            String insert = "INSERT INTO reservations (customer_name, room_number, booking_date, paid) VALUES (?, ?, ?, ?)";
            PreparedStatement istmt = conn.prepareStatement(insert);

            istmt.setString(1, name);
            istmt.setInt(2, roomNumber);
            istmt.setString(3, date);
            istmt.setBoolean(4, paid);
            istmt.executeUpdate();

            // 4. Update room availability
            String update = "UPDATE rooms SET is_available = FALSE WHERE room_number = ?";
            PreparedStatement ustmt = conn.prepareStatement(update);
            ustmt.setInt(1, roomNumber);
            ustmt.executeUpdate();

            System.out.println("Booking Successful!");
            return true;

        } catch (Exception e) {
            System.out.println("Booking Error: " + e.getMessage());
            return false;
        }
    }

    public boolean cancelBooking(String name) {
        try (Connection conn = DBConnection.getConnection()) {

            // 1. Find reservation
            String find = "SELECT * FROM reservations WHERE customer_name = ?";
            PreparedStatement fstmt = conn.prepareStatement(find);
            fstmt.setString(1, name);

            ResultSet rs = fstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("No booking found!");
                return false;
            }

            int roomNumber = rs.getInt("room_number");

            // 2. Delete reservation
            String delete = "DELETE FROM reservations WHERE customer_name = ?";
            PreparedStatement dstmt = conn.prepareStatement(delete);
            dstmt.setString(1, name);
            dstmt.executeUpdate();

            // 3. Update room availability
            String update = "UPDATE rooms SET is_available = TRUE WHERE room_number = ?";
            PreparedStatement ustmt = conn.prepareStatement(update);
            ustmt.setInt(1, roomNumber);
            ustmt.executeUpdate();

            System.out.println("Booking Cancelled!");
            return true;

        } catch (Exception e) {
            System.out.println("Cancel Error: " + e.getMessage());
            return false;
        }
    }

    public void viewBookings() {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM reservations";
            PreparedStatement stmt = conn.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            System.out.println("\n--- All Bookings ---");
            while (rs.next()) {
                System.out.println(
                        rs.getString("customer_name") +
                        " | Room: " + rs.getInt("room_number") +
                        " | Date: " + rs.getString("booking_date") +
                        " | Paid: " + (rs.getBoolean("paid") ? "Yes" : "No")
                );
            }

        } catch (Exception e) {
            System.out.println("View Error: " + e.getMessage());
        }
    }
}