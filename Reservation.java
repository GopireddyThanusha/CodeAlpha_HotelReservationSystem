public class Reservation {

    private String customerName;
    private int roomNumber;
    private String date;
    private boolean paid;

    public Reservation(String name, int roomNo, String date, boolean paid) {
        this.customerName = name;
        this.roomNumber = roomNo;
        this.date = date;
        this.paid = paid;
    }

    public String toString() {
        return "Name: " + customerName +
                " | Room: " + roomNumber +
                " | Date: " + date +
                " | Paid: " + (paid ? "Yes" : "No");
    }
}