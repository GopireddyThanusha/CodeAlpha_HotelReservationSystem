public class Payment {
    public static boolean makePayment(String name, double amount) {
        System.out.println("\nProcessing Payment ₹" + amount + " for " + name);

        try { Thread.sleep(1000); } catch (Exception e) {}

        System.out.println("Payment Successful!");
        return true;
    }
}