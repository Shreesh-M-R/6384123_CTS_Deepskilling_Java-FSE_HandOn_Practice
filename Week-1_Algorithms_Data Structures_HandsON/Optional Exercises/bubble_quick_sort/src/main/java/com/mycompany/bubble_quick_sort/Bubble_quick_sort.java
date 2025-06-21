/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bubble_quick_sort;

import java.util.*;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return orderId + " - " + customerName + " ($" + totalPrice + ")";
    }
}
public class Bubble_quick_sort {
    
      // Bubble Sort
    public static void bubbleSort(List<Order> orders) {
        int n = orders.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders.get(j).totalPrice > orders.get(j + 1).totalPrice) {
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j + 1));
                    orders.set(j + 1, temp);
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(List<Order> orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(List<Order> orders, int low, int high) {
        double pivot = orders.get(high).totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders.get(j).totalPrice < pivot) {
                i++;
                Collections.swap(orders, i, j);
            }
        }
        Collections.swap(orders, i + 1, high);
        return i + 1;
    }

    // Display orders
    public static void displayOrders(List<Order> orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Order> orders = new ArrayList<>();

        System.out.print("Enter number of orders: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for order " + (i + 1));
            System.out.print("Order ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Customer Name: ");
            String name = scanner.nextLine();

            System.out.print("Total Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            orders.add(new Order(id, name, price));
        }

        System.out.println("\nChoose sorting method:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            bubbleSort(orders);
            System.out.println("\nOrders sorted using Bubble Sort:");
        } else if (choice == 2) {
            quickSort(orders, 0, orders.size() - 1);
            System.out.println("\nOrders sorted using Quick Sort:");
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        displayOrders(orders);
        scanner.close();
    }
}