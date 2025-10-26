
import java.util.Scanner;

public class AloTicketSystem {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final double BASE_PRICE = 200;
        String day;
        int age, tickets;
        double totalPrice, discount = 0, finalPrice;
        String choice;

        while (true) {
            System.out.print("\nType 'exit' to close or press Enter to continue: ");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using the Cinema Ticketing System!");
                break;
            }
            System.out.print("Enter customer age: ");
            age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter day of the week: ");
            day = sc.nextLine();
            System.out.print("Enter number of tickets: ");
            tickets = sc.nextInt();
            sc.nextLine();
            
            double pricePerTicket = BASE_PRICE;
            String discountApplied = "None";
            if (age < 7) {
                pricePerTicket = 0;
                discountApplied = "Free for children below 7";
            } else if (age >= 60) {
                double seniorPrice = BASE_PRICE * 0.8;
                double wednesdayPrice = (day.equalsIgnoreCase("Wednesday")) ? BASE_PRICE * 0.5 : BASE_PRICE;
                if (seniorPrice < wednesdayPrice) {
                    pricePerTicket = seniorPrice;
                    discountApplied = "20% Senior Discount";
                } else if (day.equalsIgnoreCase("Wednesday")) {
                    pricePerTicket = wednesdayPrice;
                    discountApplied = "50% Wednesday Discount";
                }
            } else if (day.equalsIgnoreCase("Wednesday")) {
                pricePerTicket = BASE_PRICE * 0.5;
                discountApplied = "50% Wednesday Discount";
            }
            totalPrice = pricePerTicket * tickets;

            if (totalPrice > 1000) {
                discount = totalPrice * 0.10;
                totalPrice -= discount;
                discountApplied += " + Extra 10% Discount";
            }
            System.out.println();
            System.out.println("Tickets: " + tickets + " × ₱" + String.format("%.2f", pricePerTicket));
            System.out.println("Discount Applied: " + discountApplied);
            System.out.println("Total Amount: ₱" + String.format("%.2f", totalPrice));

            if (totalPrice < 200) {
                System.out.println("Minimum purchase not reached");
            }
        }
        
    }
}
