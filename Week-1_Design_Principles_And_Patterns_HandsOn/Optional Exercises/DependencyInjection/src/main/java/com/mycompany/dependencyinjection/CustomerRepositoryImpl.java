
package com.mycompany.dependencyinjection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<Integer, String> customerData = new HashMap<>();

    public void loadCustomers() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of customers: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Customer ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();

            customerData.put(id, name);
        }
    }

    @Override
    public String findCustomerById(int id) { 
        if (customerData.containsKey(id)) {
            return "Customer: " + customerData.get(id);
        }
        return "Customer not found.";
    }
}


