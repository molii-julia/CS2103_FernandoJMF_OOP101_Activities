import java.util.Scanner;

public class CanteenOrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] menuList = {"Sandwich", "Pancakes", "Pork Adobo", "Turon", "Buko Juice"};
        double[] menuPrice = {45, 30, 70, 25, 20};

        String orderAgain = "Y";

        int totalItems = 0;
        double totalBeforeDiscount = 0;
        double totalDiscount = 0;
        
        System.out.println("==== M E N U ====");
        
        for (int i = 0; i < menuList.length; i++) {
            System.out.println((i + 1) + ". " + menuList[i]);
            }

            while (orderAgain.equals("Y")) {
            
            System.out.print("\nEnter item number: ");
            int itemNumber = scanner.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            if (itemNumber >= 1 && itemNumber <= 5 && quantity >= 1 && quantity <= 10) {
                System.out.print("Are you a student? (Y/N): ");
                String isStudent = scanner.next();

                double subtotal = menuPrice[itemNumber - 1] * quantity;
                double discountRate;

                if (isStudent.equals("Y") && subtotal >= 500) {
                    discountRate = 0.15;
                } else if (isStudent.equals("Y") && subtotal < 500) {
                    discountRate = 0.10;
                } else if (isStudent.equals("N") && subtotal >= 500) {
                    discountRate = 0.05;
                } else {
                    discountRate = 0;
                }

                double discountAmount = subtotal * discountRate;
                double total = subtotal - discountAmount;

                System.out.printf("\nSubtotal: $%.2f%n", subtotal);
                System.out.printf("Discount: $%.2f%n", discountAmount);
                System.out.printf("Order total: $%.2f%n", total);

                totalItems += quantity;
                totalBeforeDiscount += subtotal;
                totalDiscount += discountAmount;
            } else {
                System.out.println("\nInvalid order! Please enter a valid item and quantity.");
            }

            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = scanner.next();
        }

        double finalAmount = totalBeforeDiscount - totalDiscount;

        System.out.println("\n==== ORDER SUMMARY ====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f%n", totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount: $%.2f%n", finalAmount);

        System.out.println("Thank you for ordering!");

        scanner.close();
    }
}
