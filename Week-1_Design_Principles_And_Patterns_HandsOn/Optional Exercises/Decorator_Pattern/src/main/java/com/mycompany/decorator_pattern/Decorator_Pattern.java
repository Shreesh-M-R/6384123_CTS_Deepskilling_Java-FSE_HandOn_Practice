/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.decorator_pattern;

import java.util.Scanner;

/**
 *
 * @author lavan
 */

public class Decorator_Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Notification System Using Decorator Pattern");
        System.out.print("Enter your message: ");
        String message = sc.nextLine();

        Notifier notifier = new EmailNotifier(); 
        System.out.println("\nSelect additional notification channels (yes/no):");

        System.out.print("Add SMS? ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            notifier = new SMSNotifierDecorator(notifier);
        }

        System.out.print("Add Slack? ");
        if (sc.nextLine().equalsIgnoreCase("yes")) {
            notifier = new SlackNotifierDecorator(notifier);
        }

        System.out.println("\nSending Notification...");
        notifier.send(message);
    }
}