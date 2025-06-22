package com.mycompany.strategypattern;
import java.util.Scanner;

public class StrategyPattern {

 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext context = new PaymentContext();

        while (true) {
            System.out.println("\n--- Select Payment Method ---");
            System.out.println("1. Credit Card");
            System.out.println("2. PayPal");
            System.out.println("3. UPI");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 4) break;

            System.out.print("Enter amount: ₹");
            double amount = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.print("Enter card number: ");
                    String card = scanner.next();
                    context.setStrategy(new CreditCardPayment(card));
                    break;
                case 2:
                    System.out.print("Enter PayPal email: ");
                    String email = scanner.next();
                    context.setStrategy(new PayPalPayment(email)); 
                    break;
                case 3:
                    System.out.print("Enter UPI ID: ");
                    String upi = scanner.next();
                    context.setStrategy(new UpiPayment(upi)); 
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            context.executePayment(amount); 
        }

        scanner.close();
        System.out.println("Payment system closed.");
    }
}
