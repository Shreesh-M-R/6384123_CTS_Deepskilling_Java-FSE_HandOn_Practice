package com.mycompany.decoratorpattern;
import java.util.Scanner;
public class DecoratorPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Notifier baseNotifier = new EmailNotifier(); 
        while (true) {
            System.out.println("\n=== Notification Menu ===");
            System.out.println("1. Send Email only");
            System.out.println("2. Send Email + SMS");
            System.out.println("3. Send Email + SMS + Slack");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 4) {
                System.out.println("Exiting Notification System...");
                break;
            }

            System.out.print("Enter message to send: ");
            String message = sc.nextLine();

            Notifier notifier;

            switch (choice) {
                case 1:
                    notifier = baseNotifier; 
                    break;
                case 2:
                    notifier = new SMSNotifierDecorator(baseNotifier); 
                    break;
                case 3:
                    notifier = new SlackNotifierDecorator(
                                new SMSNotifierDecorator(baseNotifier));
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            notifier.send(message); 
        }

        sc.close();
    }
}