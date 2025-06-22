
package com.mycompany.dependencyinjection;
import java.util.Scanner;
public class DependencyInjection {

public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerRepositoryImpl repository = new CustomerRepositoryImpl();
        repository.loadCustomers(); 

        CustomerService service = new CustomerService(repository);

        while (true) {
            System.out.print("\nEnter Customer ID (0 to exit): ");
            int id = sc.nextInt();
            if (id == 0) {
                System.out.println("Exiting");
                break;
            }
            service.displayCustomerById(id); 
        }

        sc.close();
    }
}
